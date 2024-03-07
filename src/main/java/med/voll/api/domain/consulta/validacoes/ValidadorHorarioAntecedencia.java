package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;

public class ValidadorHorarioAntecedencia {

    public void validar(DadosAgendamentoConsulta dados) {
        var dataDaConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataDaConsulta).toMinutes();
        if(diferencaEmMinutos < 30) {
            throw new ValidacaoException("Consulta deve ser agendada com antecedencia minima de 30 minutos");
        }

    }
}
