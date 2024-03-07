package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

import java.time.DayOfWeek;

public class ValidadorHorarioFuncionamentoClinica {

    public void validar(DadosAgendamentoConsulta dados) {
        var dataDaConsulta = dados.data();
        var domingo = dataDaConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica = dataDaConsulta.getHour() < 7;
        var depoisDoEncerramentoDaClinica = dataDaConsulta.getHour() > 18;
        if(domingo || antesDaAberturaDaClinica || depoisDoEncerramentoDaClinica) {
            throw new ValidacaoException("Consulta forado horario de funcionamento da clinica");
        }
    }
}
