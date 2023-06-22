package SistemaMedico.Persistencia;

import SistemaMedico.Modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioClasseDAO  implements UsuarioInterfaceDAO{
    Connection con;
    public UsuarioClasseDAO() throws ErroDao
    {
        con=FabricaConexao.pegaConexao();
    }
    @Override
    //public class
    public void inserir(Usuario u) throws ErroDao {
        String sql;
        if (u.isMedico())
        {
            sql = "INSERT INTO usuario (login, senha, nome, email, sexo, mae_nome, municipio, estado, endereco, data_nascimento,is_medico, crm, especialidade) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        } else {
            sql = "INSERT INTO usuario (login, senha, nome, email, sexo, mae_nome, municipio, estado, endereco, data_nascimento, is_medico) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        }

        try (PreparedStatement pstm = con.prepareStatement(sql))
        {
            pstm.setString(1, u.getLogin());
            pstm.setString(2, u.getSenha());
            pstm.setString(3, u.getNome());
            pstm.setString(4, u.getEmail());
            pstm.setString(5, u.getSexo());
            pstm.setString(6, u.getMaenome());
            pstm.setString(7, u.getMunicipio());
            pstm.setString(8, u.getEstado());
            pstm.setString(9, u.getEndereco());
            pstm.setString(10, u.getDataNascimento());
            pstm.setBoolean(11, u.isMedico());

            if (u.isMedico()) {
                pstm.setString(12, u.getCrm());
                pstm.setString(13, u.getEspecialidade());
            }

            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }
    @Override
    public void deletar(String login) throws ErroDao {
        String sql = "DELETE FROM usuario WHERE login = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, login);
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public void editar(String login, String senha, String endereco) throws ErroDao
    {
        String sql = "UPDATE usuario set senha = ?, endereco=? WHERE login = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, senha);
            pstm.setString(2, endereco);
            pstm.setString(3, login);
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public void editar(Usuario u) throws ErroDao
    {
        String sql= "UPDATE usuario set senha= ?, nome= ?, email= ?, sexo= ?, mae_nome= ?, municipio= ?, estado= ?, endereco= ?, data_nascimento= ?,is_medico= ?, crm= ?, especialidade= ? WHERE login = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql))
        {
            pstm.setString(1, u.getSenha());
            pstm.setString(2, u.getNome());
            pstm.setString(3, u.getEmail());
            pstm.setString(4, u.getSexo());
            pstm.setString(5, u.getMaenome());
            pstm.setString(6, u.getMunicipio());
            pstm.setString(7, u.getEstado());
            pstm.setString(8, u.getEndereco());
            pstm.setString(9, u.getDataNascimento());
            pstm.setBoolean(10, u.isMedico());
            if (u.isMedico()) {
                pstm.setString(11, u.getCrm());
                pstm.setString(12, u.getEspecialidade());
            }
            else {
                pstm.setString(11, "");
                pstm.setString(12, "");
            }
            pstm.setString(13, u.getLogin());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    public List<Usuario> buscar() throws ErroDao
    {
        String sql = "SELECT login, nome, data_nascimento FROM usuario WHERE is_medico = false";
        try(PreparedStatement pstm=con.prepareStatement(sql)) {
            ResultSet rs=pstm.executeQuery();
            List<Usuario> usuarios=new ArrayList();
            while (rs.next())
            {
                Usuario u=new Usuario();
                u.setLogin(rs.getString("login"));
                u.setNome(rs.getString("nome"));
                u.setDataNascimento(rs.getString("data_nascimento"));
                usuarios.add(u);
            }
            return usuarios;
        }catch (SQLException e)
        {
            throw new ErroDao(e);
        }
    }

    @Override
    public List<Usuario> buscar(String nome, String tipo) throws ErroDao {
        String sql = "SELECT * FROM usuario WHERE nome LIKE ? AND is_medico = false";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, "%" + nome + "%");
            ResultSet rs = pstm.executeQuery();
            List<Usuario> usuarios = new ArrayList<>();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setLogin(rs.getString("login"));
                u.setNome(rs.getString("nome"));
                u.setDataNascimento(rs.getString("data_nascimento"));
                usuarios.add(u);
            }
            return usuarios;
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }


    @Override
    public Usuario buscar(String login) throws ErroDao
    {
        String sql= "SELECT * FROM usuario WHERE login = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, login);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setLogin(rs.getString("login"));
                    usuario.setSenha(rs.getString("senha"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setSexo(rs.getString("sexo"));
                    usuario.setMaenome(rs.getString("mae_nome"));
                    usuario.setMunicipio(rs.getString("municipio"));
                    usuario.setEstado(rs.getString("estado"));
                    usuario.setEndereco(rs.getString("endereco"));
                    usuario.setDataNascimento(rs.getString("data_nascimento"));
                    usuario.setMedico(rs.getBoolean("is_medico"));
                    usuario.setCrm(rs.getString("crm"));
                    usuario.setEspecialidade(rs.getString("especialidade"));
                    return usuario;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public Usuario buscar(Usuario u) throws ErroDao {
        String sql = "SELECT nome, is_medico FROM usuario WHERE login = ? AND senha = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql))
        {
            pstm.setString(1, u.getLogin());
            pstm.setString(2, u.getSenha());
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setLogin(u.getLogin());
                    usuario.setNome(rs.getString("nome"));
                    usuario.setMedico(rs.getBoolean("is_medico"));
                    return usuario;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }
    @Override
    public void sair() throws ErroDao
    {

    }
}
