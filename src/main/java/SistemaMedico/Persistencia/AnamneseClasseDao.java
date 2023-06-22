package SistemaMedico.Persistencia;

import SistemaMedico.Modelo.Anamnese;
import SistemaMedico.Modelo.Usuario;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AnamneseClasseDao implements AnamneseInterface{
    Connection con;
    public AnamneseClasseDao() throws ErroDao
    {
        con=FabricaConexao.pegaConexao();
    }
    @Override
    public void inserir(Anamnese a) throws ErroDao
    {
        String sql = "INSERT INTO anamnese (loginPaciente, loginMedico, exameFisico, examesComplementares, resultadosExames, hipotesesDiagnosticas, tratamentoEfetuado, diagnosticoDefinitivo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, a.getLoginPaciente());
            pstm.setString(2, a.getLoginMedico());
            pstm.setString(3, a.getExameFisico());
            pstm.setString(4, a.getExamesComplementares());
            pstm.setString(5, a.getResultadosExames());
            pstm.setString(6, a.getHipotesesDiagnosticas());
            pstm.setString(7, a.getTratamentoEfetuado());
            pstm.setString(8, a.getDiagnosticoDefinitivo());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }
    @Override
    public List<Anamnese> buscar(String loginPaciente) throws ErroDao {
        List<Anamnese> anamneses = new ArrayList<>();
        String sql = "SELECT id, loginMedico, dataCriacao FROM anamnese WHERE loginPaciente = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, loginPaciente);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String loginMedico = rs.getString("loginMedico");
                Timestamp timestamp = rs.getTimestamp("dataCriacao");
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String data = dateFormat.format(timestamp);
                Anamnese anamnese = new Anamnese();
                anamnese.setId(id);
                anamnese.setLoginMedico(loginMedico);
                anamnese.setData(data);
                anamneses.add(anamnese);
            }
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
        return anamneses;
    }
    @Override
    public Anamnese buscar(int id) throws ErroDao {
        Anamnese anamnese = null;
        String sql = "SELECT * FROM anamnese WHERE id = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                anamnese = new Anamnese(rs.getString("loginPaciente"),
                        rs.getString("loginMedico"),
                        rs.getString("exameFisico"),
                        rs.getString("examesComplementares"),
                        rs.getString("resultadosExames"),
                        rs.getString("hipotesesDiagnosticas"),
                        rs.getString("tratamentoEfetuado"),
                        rs.getString("diagnosticoDefinitivo"));
                anamnese.setId(rs.getInt("id"));
                Timestamp timestamp = rs.getTimestamp("dataCriacao");
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String data = dateFormat.format(timestamp);
                anamnese.setData(data);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return anamnese;
    }
    @Override
    public List<Anamnese> buscarAnamnesesAposData(String loginPaciente, String data) throws ErroDao {
        //a data vem no formato yyyy--MM--dd
        List<Anamnese> anamneses = new ArrayList<>();
        String sql = "SELECT id, loginMedico, dataCriacao FROM anamnese WHERE loginPaciente = ? AND dataCriacao > ?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, loginPaciente);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate;
            try {
                parsedDate = dateFormat.parse(data);
            } catch (ParseException e) {
                throw new IllegalArgumentException("Formato incorreto");
            }
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
            pstm.setDate(2, sqlDate);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String loginMedico = rs.getString("loginMedico");
                Timestamp timestamp = rs.getTimestamp("dataCriacao");
                String dataCriacao = dateFormat.format(timestamp);
                Anamnese anamnese = new Anamnese();
                anamnese.setId(id);
                anamnese.setLoginMedico(loginMedico);
                anamnese.setData(dataCriacao);
                anamneses.add(anamnese);
            }
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
        return anamneses;
    }

    @Override
    public void sair() throws ErroDao {

    }
}
