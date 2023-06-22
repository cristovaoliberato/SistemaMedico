package SistemaMedico.Modelo;

public class Anamnese
{
    private String loginPaciente, loginMedico, exameFisico, examesComplementares,
            resultadosExames, hipotesesDiagnosticas, tratamentoEfetuado, diagnosticoDefinitivo, data;
    private int id;
    public Anamnese()
    {
    }

    public Anamnese(String loginPaciente, String loginMedico, String exameFisico, String examesComplementares, String resultadosExames, String hipotesesDiagnosticas, String tratamentoEfetuado, String diagnosticoDefinitivo) {
        this.loginPaciente = loginPaciente;
        this.loginMedico = loginMedico;
        this.exameFisico = exameFisico;
        this.examesComplementares = examesComplementares;
        this.resultadosExames = resultadosExames;
        this.hipotesesDiagnosticas = hipotesesDiagnosticas;
        this.tratamentoEfetuado = tratamentoEfetuado;
        this.diagnosticoDefinitivo = diagnosticoDefinitivo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginPaciente() {
        return loginPaciente;
    }

    public void setLoginPaciente(String loginPaciente) {
        this.loginPaciente = loginPaciente;
    }

    public String getLoginMedico() {
        return loginMedico;
    }

    public void setLoginMedico(String loginMedico) {
        this.loginMedico = loginMedico;
    }

    public String getExameFisico() {
        return exameFisico;
    }

    public void setExameFisico(String exameFisico) {
        this.exameFisico = exameFisico;
    }

    public String getExamesComplementares() {
        return examesComplementares;
    }

    public void setExamesComplementares(String examesComplementares) {
        this.examesComplementares = examesComplementares;
    }

    public String getResultadosExames() {
        return resultadosExames;
    }

    public void setResultadosExames(String resultadosExames) {
        this.resultadosExames = resultadosExames;
    }

    public String getHipotesesDiagnosticas() {
        return hipotesesDiagnosticas;
    }

    public void setHipotesesDiagnosticas(String hipotesesDiagnosticas) {
        this.hipotesesDiagnosticas = hipotesesDiagnosticas;
    }

    public String getTratamentoEfetuado() {
        return tratamentoEfetuado;
    }

    public void setTratamentoEfetuado(String tratamentoEfetuado) {
        this.tratamentoEfetuado = tratamentoEfetuado;
    }

    public String getDiagnosticoDefinitivo() {
        return diagnosticoDefinitivo;
    }

    public void setDiagnosticoDefinitivo(String diagnosticoDefinitivo) {
        this.diagnosticoDefinitivo = diagnosticoDefinitivo;
    }

    @Override
    public String toString() {
        return "Anamnese{" +
                "loginPaciente='" + loginPaciente + '\'' +
                ", loginMedico='" + loginMedico + '\'' +
                ", exameFisico='" + exameFisico + '\'' +
                ", examesComplementares='" + examesComplementares + '\'' +
                ", resultadosExames='" + resultadosExames + '\'' +
                ", hipotesesDiagnosticas='" + hipotesesDiagnosticas + '\'' +
                ", tratamentoEfetuado='" + tratamentoEfetuado + '\'' +
                ", diagnosticoDefinitivo='" + diagnosticoDefinitivo + '\'' +
                ", data='" + data + '\'' +
                ", id=" + id +
                '}';
    }
}
