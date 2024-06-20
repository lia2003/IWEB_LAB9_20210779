package com.example.lab9_20210779;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    public List<Usuario> getUsuariosOperativos() {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT u.nombres, u.apellidos, l.categoria, p.nombre_pais, " +
                "(SELECT COUNT(*) FROM renta_auto r WHERE r.usuario_idusuario = u.idusuario AND r.cancelada = 1 AND YEAR(r.fecha_inicio) = YEAR(CURDATE())) AS reservas_canceladas, " +
                "IF(CURDATE() > l.fecha_emision AND CURDATE() < l.fecha_caducidad, 'Vigente', 'No vigente') AS estado_licencia " +
                "FROM usuario u " +
                "JOIN licencia l ON u.licencia_idlicencia = l.idlicencia " +
                "JOIN pais p ON l.pais_idpais = p.idpais " +
                "WHERE u.rol_idrol = 1";

        try (Connection connection = BaseDatos.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setNombres(rs.getString("nombres"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setTipoLicencia(rs.getString("categoria"));
                usuario.setPaisProcedencia(rs.getString("nombre_pais"));
                usuario.setReservasCanceladas(rs.getInt("reservas_canceladas"));
                usuario.setEstadoLicencia(rs.getString("estado_licencia"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}
