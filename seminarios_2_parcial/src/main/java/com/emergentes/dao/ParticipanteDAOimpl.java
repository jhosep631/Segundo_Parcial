package com.emergentes.dao;

import com.emergentes.modelo.Participante;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ParticipanteDAOimpl extends ConexionDB implements ParticipanteDAO {

    @Override
    public void insert(Participante participante) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO participantes (apellidos, nombres, id_seminario, confirmado) VALUES (?,?,?,?)");
            ps.setString(1, participante.getApellidos());
            ps.setString(2, participante.getNombres());
            ps.setInt(3, participante.getId_seminario());
            ps.setInt(4, participante.getConfirmado());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Participante participante) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE participantes SET apellidos = ?, nombres = ?, id_seminario = ?, confirmado = ? WHERE id = ?");
            ps.setString(1, participante.getApellidos());
            ps.setString(2, participante.getNombres());
            ps.setInt(3, participante.getId_seminario());
            ps.setInt(4, participante.getConfirmado());
            ps.setInt(5, participante.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM participantes WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Participante getById(int id) throws Exception {
        Participante par = new Participante();
        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM participantes WHERE id = ? ");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                par.setId(rs.getInt("id"));
                par.setApellidos(rs.getString("apellidos"));
                par.setNombres(rs.getString("nombres"));
                par.setId_seminario(rs.getInt("id_seminario"));
                par.setConfirmado(rs.getInt("confirmado"));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return par;
    }

    @Override
    public List<Participante> getAll() throws Exception {
        List<Participante> lista = null;

        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("select p.*, s.titulo as seminario from seminarios s, participantes p WHERE p.id_seminario = s.id ORDER BY p.id ASC;");
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Participante>();
            while (rs.next()) {
                Participante par = new Participante();

                par.setId(rs.getInt("id"));
                par.setNombres(rs.getString("nombres"));
                par.setApellidos(rs.getString("apellidos"));
                par.setSeminario(rs.getString("seminario"));
                par.setConfirmado(rs.getInt("confirmado"));
                par.setId_seminario(rs.getInt("id_seminario"));

                lista.add(par);
            }
            rs.close();
            ps.close();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }

}
