package SistemaMedico.Modelo;
public  class Usuario
{
    private String login, senha, nome, email, sexo, maenome, municipio, estado, endereco, dataNascimento, especialidade, crm;
    private boolean medico;
    public Usuario(){}
    public Usuario(String login, String senha, String nome, String email, String sexo, String maenome, String municipio, String estado, String endereco, String dataNascimento, boolean isdoctor) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.sexo = sexo;
        this.maenome = maenome;
        this.municipio = municipio;
        this.estado = estado;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.medico = medico;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getMaenome() {
        return maenome;
    }

    public void setMaenome(String maenome) {
        this.maenome = maenome;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public boolean isMedico() {
        return medico;
    }

    public void setMedico(boolean medico) {
        this.medico = medico;
    }
}
