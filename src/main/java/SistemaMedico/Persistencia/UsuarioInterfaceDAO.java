package SistemaMedico.Persistencia;

import SistemaMedico.Modelo.Usuario;

import java.lang.invoke.StringConcatFactory;
import java.util.List;

public interface UsuarioInterfaceDAO {
    public void inserir(Usuario u) throws ErroDao;

    public void deletar(String login) throws ErroDao;

    public void editar(String login, String senha, String endereco) throws ErroDao;
    public void editar(Usuario u) throws ErroDao;
    public Usuario buscar(Usuario u) throws ErroDao;
    public List<Usuario> buscar() throws ErroDao;
    public List<Usuario> buscar(String nome, String tipo) throws ErroDao;
    public Usuario buscar(String login) throws ErroDao;
    public void sair() throws ErroDao;
}
