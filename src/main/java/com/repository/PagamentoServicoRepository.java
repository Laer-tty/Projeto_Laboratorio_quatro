package com.repository;

import com.model.Aluguel;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class PagamentoServicoRepository {

    private final AluguelRepository aluguelRepository;

    public PagamentoServicoRepository(AluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    @Transactional
    public void registrarPagamento(Long aluguelId, LocalDate dataPagamento) {
        Aluguel aluguel = aluguelRepository.findById(Math.toIntExact(aluguelId));

        if (aluguel != null) {
            Date dataPagamentoDate = Date.from(dataPagamento.atStartOfDay(ZoneId.systemDefault()).toInstant());
            aluguel.setDataPagamento(dataPagamentoDate);

            Date dataVencimentoDate = aluguel.getDataVencimento();
            BigDecimal valorAluguel = aluguel.getValorPago();

            LocalDate dataVencimento = dataVencimentoDate.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();

            long diasAtraso = ChronoUnit.DAYS.between(dataVencimento, dataPagamento);

            BigDecimal multa = BigDecimal.ZERO;
            if (diasAtraso > 0) {
                BigDecimal diasAtrasoBD = BigDecimal.valueOf(diasAtraso);
                BigDecimal percentualMulta = new BigDecimal("0.0033"); // 0.33%
                multa = valorAluguel.multiply(percentualMulta).multiply(diasAtrasoBD).min(new BigDecimal("20.00"));
            }

            aluguel.setValorPago(valorAluguel.add(multa));
            aluguelRepository.update(aluguel);
        }
    }
}
