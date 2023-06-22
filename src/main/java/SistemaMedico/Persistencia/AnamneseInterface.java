package SistemaMedico.Persistencia;

import SistemaMedico.Modelo.Anamnese;
import SistemaMedico.Modelo.Usuario;

import java.util.List;

public interface AnamneseInterface {
    public void inserir(Anamnese a) throws ErroDao;
    public List<Anamnese> buscar(String login) throws ErroDao;
    public List<Anamnese> buscarAnamnesesAposData(String loginPaciente, String data) throws ErroDao;
    public Anamnese buscar(int id) throws ErroDao;
    public void sair() throws ErroDao;
}
