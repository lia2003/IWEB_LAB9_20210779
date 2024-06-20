<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.example.lab9_20210779.Usuario" %>
<%@ page import="java.util.List, java.util.ArrayList" %>


<%

    String jdbcUrl = "jdbc:mysql://localhost:3306/lab9_db_h691";
    String dbUser = "root";
    String dbPassword = "root";

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

        String sql = "SELECT * FROM usuarios";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();

        List<Usuario> usuarios = new ArrayList<>();
        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setNombres(rs.getString("nombres"));
            usuario.setApellidos(rs.getString("apellidos"));
            usuario.setTipoLicencia(rs.getString("tipo_licencia"));
            usuario.setEstadoLicencia(rs.getString("estado_licencia"));
            usuario.setPaisProcedencia(rs.getString("pais_procedencia"));
            usuario.setReservasCanceladas(rs.getInt("reservas_canceladas"));

            usuarios.add(usuario);
        }


        request.setAttribute("usuarios", usuarios);

    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    } finally {

        try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
        try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
        try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
    }
%>

<html>
<head>
    <title>Lista de Usuarios Operativos</title>
</head>
<body>
<h1>Lista de Usuarios Operativos</h1>
<table border="1">
    <tr>
        <th>Nombres</th>
        <th>Apellidos</th>
        <th>Tipo de Licencia</th>
        <th>Estado de la Licencia</th>
        <th>País de Procedencia</th>
        <th>Reservas Canceladas</th>
    </tr>
    <% for (Usuario usuario : usuarios){ %>
    <tr>
        <td><%= usuario.getNombres() %></td>
        <td><%= usuario.getApellidos() %></td>
        <td><%= usuario.getTipoLicencia() %></td>
        <td><%= usuario.getEstadoLicencia() %></td>
        <td><%= usuario.getPaisProcedencia() %></td>
        <td><%= usuario.getReservasCanceladas() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>
