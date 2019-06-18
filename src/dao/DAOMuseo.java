package dao;

import modelo.Cliente;
import modelo.Entrada;
import modelo.Exposicion;
import modelo.Guia;
import modelo.Obra;
import modelo.Administrador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Todos
 */
public class DAOMuseo {

    // Atributos --------------------------------------------
    static DAOMuseo instancia = null;

    // Constructor ---------------------------------------------
    private DAOMuseo() {

    }

    // Métodos --------------------------------------------------
    public static DAOMuseo instanciar() {
        if (instancia == null) {
            instancia = new DAOMuseo();
        }

        return instancia;
    }

    // ############################# INICIO DE SESIÓN #############################
    // Devuelve el rol de esa persona para que visualice el frame asignado a su rol
    public String obtenerRol(String dni) throws SQLException {
        String rol = "";
        String query = "SELECT rol FROM persona WHERE dni = ?";

        PreparedStatement ps = ConexionBD.instancia().getConnection().prepareStatement(query);
        ps.setString(1, dni);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            rol = rs.getString("rol");
        }

        return rol;
    }

    // Devuelve booleano en función de si existe o no un usuario con el dni pasado por parámetro en la Base de Datos
    public boolean existeUsuario(String dni) throws SQLException {
        boolean existe = false;
        String query = "SELECT * FROM persona WHERE dni = ?";

        PreparedStatement ps = ConexionBD.instancia().getConnection().prepareStatement(query);
        ps.setString(1, dni);

        ResultSet rs = ps.executeQuery();
        // Si hay siguiente es que existe una entrada en la tabla y ya hay alguien registrado con ese dni
        if (rs.next()) {
            existe = true;
        }

        return existe;
    }

    // Devuelve true si el dni y la contraseña pasadas por parametro coinciden con los de algun usuario registrado en la Base de Datos 
    public boolean comprobarCredenciales(String dni, String password) throws SQLException {
        boolean correcto = false;
        String query = "SELECT dni, clave FROM persona WHERE dni = ? AND clave = SHA(?)";

        PreparedStatement ps = ConexionBD.instancia().getConnection().prepareStatement(query);
        ps.setString(1, dni);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            correcto = true;
        }

        return correcto;
    }
    
    
    // ########################## CAMBIAR CONTRASEÑA ######################
    
    public boolean cambiarContraseña(String passAntigua, String passNueva, String dniUsuario) throws SQLException{
        boolean cambiada = false;
        
        String query = "SELECT * FROM persona WHERE dni = ? and clave = SHA(?) ";
        String update = "UPDATE clave FROM persona VALUES ?";
        
        PreparedStatement ps = ConexionBD.instancia().getConnection().prepareStatement(query);
        ps.setString(1, dniUsuario);
        ps.setString(2, passAntigua);
        
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
            
            PreparedStatement ps2 = ConexionBD.instancia().getConnection().prepareStatement(update);
            ps.setString(1, passNueva);
            ResultSet rs2 = ps2.executeQuery();
            cambiada = true;
        }
        
        
        return cambiada;
    }
    
    

    // ############################# CLIENTE #############################
    public void nuevoCliente(Cliente c, String password) throws SQLException {
        String insert1 = "INSERT INTO persona VALUES (?, SHA(?), ?, ?, 'cliente')";
        String insert2 = "INSERT INTO cliente (dniCliente) VALUES (?)";
        // INSERT INTO persona VALUES (dni, clave, nombre, telefono, 'cliente')
        PreparedStatement ps1 = ConexionBD.instancia().getConnection().prepareStatement(insert1);
        ps1.setString(1, c.getDNI());
        ps1.setString(2, password);
        ps1.setString(3, c.getNombre());
        ps1.setInt(4, c.getTelefono());
        // INSERT INTO cliente (dniCliente) VALUES (dni)
        PreparedStatement ps2 = ConexionBD.instancia().getConnection().prepareStatement(insert2);
        ps2.setString(1, c.getDNI());
        // Se ejecutan las updates
        ps1.executeUpdate();
        ps2.executeUpdate();
    }

    public Cliente cargarCliente(String dni) throws SQLException {
        Cliente c = null;
        String query1 = "SELECT nombre, dni, telefono FROM persona WHERE dni = ?";
        String query2 = "SELECT idCliente FROM cliente WHERE dniCliente = ?";

        PreparedStatement ps1 = ConexionBD.instancia().getConnection().prepareStatement(query1);
        ps1.setString(1, dni);

        PreparedStatement ps2 = ConexionBD.instancia().getConnection().prepareStatement(query2);
        ps2.setString(1, dni);

        ResultSet rs1 = ps1.executeQuery();
        ResultSet rs2 = ps2.executeQuery();

        if (rs1.next() && rs2.next()) {
            c = new Cliente(rs1.getString("nombre"), rs1.getString("dni"), rs1.getInt("telefono"), rs2.getInt("idCliente"));
        }

        return c;
    }

    public void introducirTarjeta(long tarjeta) throws SQLException {
        String insert = "INSERT INTO cliente (tarjeta) VALUES (?)";

        // INSERT INTO persona VALUES (dni, clave, nombre, telefono, 'administrador')
        PreparedStatement ps = ConexionBD.instancia().getConnection().prepareStatement(insert);
        ps.setLong(1, tarjeta);

        // Se ejecutan las updates
        ps.executeUpdate();
    }

    // Obtiene los datos de la tarjeta de un cliente determinado (FALTA POR IMPLEMENTAR)
    public long obtenerTarjetaCliente(int idCliente) throws SQLException {
        long tarjeta = -1;
        String query = "SELECT tarjeta FROM cliente WHERE idCliente = ?";
        PreparedStatement ps = ConexionBD.instancia().getConnection().prepareStatement(query);
        ps.setLong(1, idCliente);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            tarjeta = rs.getLong("tarjeta");
        }

        return tarjeta;
    }

    // ############################# ADMINISTRADOR #############################
    public void nuevoAdministrador(Administrador a, String password) throws SQLException {
        String insert1 = "INSERT INTO persona VALUES (?, SHA(?), ?, ?, 'administrador')";
        String insert2 = "INSERT INTO administrador (numSeguridadSocial, dniGuia) VALUES (?, ?)";
        // INSERT INTO persona VALUES (dni, clave, nombre, telefono, 'administrador')
        PreparedStatement ps1 = ConexionBD.instancia().getConnection().prepareStatement(insert1);
        ps1.setString(1, a.getDNI());
        ps1.setString(2, password);
        ps1.setString(3, a.getNombre());
        ps1.setInt(4, a.getTelefono());
        // INSERT INTO administrador (numSeguridadSocial, dniGuia) VALUES (numeroSeguridadSocial, dni)
        PreparedStatement ps2 = ConexionBD.instancia().getConnection().prepareStatement(insert2);
        ps2.setLong(1, a.getNSS());
        ps2.setString(2, a.getDNI());
        // Se ejecutan las updates
        ps1.executeUpdate();
        ps2.executeUpdate();
    }

    public Administrador cargarAdministrador(String dni) throws SQLException {
        Administrador a = null;
        String query1 = "SELECT nombre, dni, telefono FROM persona WHERE dni = ?";
        String query2 = "SELECT numIdentificacion, numSeguridadSocial FROM administrador WHERE dniAdministrador = ?";

        PreparedStatement ps1 = ConexionBD.instancia().getConnection().prepareStatement(query1);
        ps1.setString(1, dni);

        PreparedStatement ps2 = ConexionBD.instancia().getConnection().prepareStatement(query2);
        ps2.setString(1, dni);

        ResultSet rs1 = ps1.executeQuery();
        ResultSet rs2 = ps2.executeQuery();

        if (rs1.next() && rs2.next()) {
            a = new Administrador(rs1.getString("nombre"), rs1.getString("dni"), rs1.getInt("telefono"),
                    rs2.getLong("numSeguridadSocial"), rs2.getInt("numIdentificacion"), cargarEmpleados(), cargarExposiciones());
        }
        return a;
    }

    // ############################# GUÍA #############################
    public void nuevoGuia(Guia g, String password) throws SQLException {
        String insert1 = "INSERT INTO persona (dni, clave, nombre, telefono, rol) VALUES (?, SHA(?), ?, ?, 'guia')";
        String insert2 = "INSERT INTO guia (numSeguridadSocial, dniGuia, numGuia) VALUES (?, ?, ?)";
        // INSERT INTO persona VALUES (dni, clave, nombre, telefono, 'guia')
        PreparedStatement ps1 = ConexionBD.instancia().getConnection().prepareStatement(insert1);
        ps1.setString(1, g.getDNI());
        ps1.setString(2, password);
        ps1.setString(3, g.getNombre());
        ps1.setInt(4, g.getTelefono());
        // INSERT INTO guia (numSeguridadSocial, dniGuia) VALUES (numeroSeguridadSocial, dni)
        PreparedStatement ps2 = ConexionBD.instancia().getConnection().prepareStatement(insert2);
        ps2.setLong(1, g.getNSS());
        ps2.setString(2, g.getDNI());
        ps2.setInt(3, g.getNGuia());
        // Se ejecutan las updates
        ps1.executeUpdate();
        ps2.executeUpdate();
    }

    public Guia cargarGuia(String dni) throws SQLException {
        Guia g = null;
        String query1 = "SELECT nombre, dni, telefono FROM persona WHERE dni = ?";
        String query2 = "SELECT numIdentificacion, numSeguridadSocial, numGuia FROM guia WHERE dniGuia = ?";

        PreparedStatement ps1 = ConexionBD.instancia().getConnection().prepareStatement(query1);
        ps1.setString(1, dni);

        PreparedStatement ps2 = ConexionBD.instancia().getConnection().prepareStatement(query2);
        ps2.setString(1, dni);

        ResultSet rs1 = ps1.executeQuery();
        ResultSet rs2 = ps2.executeQuery();

        if (rs1.next() && rs2.next()) {
            g = new Guia(rs1.getString("nombre"), rs1.getString("dni"), rs1.getInt("telefono"),
                    rs2.getLong("numSeguridadSocial"), rs2.getInt("numIdentificacion"), rs2.getInt("numGuia"));
        }

        return g;
    }

    // Implementa las entradas asociadas a un guía
    public List cargarEntradasGuia(int numGuia) throws SQLException {
        List entradasGuia = new ArrayList();

        String query = "SELECT cliente.dniCliente, entrada.fechaReserva, entrada.hora, "
                + "entrada.fechaTransaccion FROM cliente, entrada, guia, guia_entrada WHERE "
                + "entrada.idCliente = cliente.idCliente AND entrada.numEntrada = guia_entrada.numEntrada "
                + "AND guia_entrada.numGuia = guia.numGuia AND guia.numGuia = ?";

        PreparedStatement ps = ConexionBD.instancia().getConnection().prepareStatement(query);
        ps.setInt(1, numGuia);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            entradasGuia.add(new Entrada(rs.getInt("entrada.numeroEntrada"), rs.getDate("entrada.fechaReserva"), rs.getString("entrada.hora"), rs.getString("entradafechaTransaccion")));
        }

        return entradasGuia;
    }

    // Algoritmo que escoge el número de guía basado en porcentajes equitativos
    public int elegirNumGuia() throws SQLException {
        String query = "SELECT numGuia FROM guia";
        int[] arrayGuias = new int[numeroGuias()];

        PreparedStatement ps = ConexionBD.instancia().getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        int i = 0;

        while (rs.next()) {
            arrayGuias[i++] = rs.getInt("numGuia");
        }

        int random = (int) (Math.random() * numeroGuias());
        int numGuia = arrayGuias[random];

        return numGuia;
    }

    // Obtiene el número de guías registrados
    private int numeroGuias() throws SQLException {
        String query = "SELECT COUNT(numIdentificacion) FROM guia";
        int numeroGuias = -1;

        PreparedStatement ps = ConexionBD.instancia().getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            numeroGuias = rs.getInt("COUNT(numIdentificacion)");
        }

        return numeroGuias;
    }

    public void despedirGuia(Guia guiaDespedido) throws SQLException {

        String delete1 = "DELETE FROM guia WHERE numGuia = ?";
        String delete2 = "DELETE FROM persona WHERE dni = ?";

        PreparedStatement ps = ConexionBD.instancia().getConnection().prepareStatement(delete1);
        PreparedStatement ps2 = ConexionBD.instancia().getConnection().prepareStatement(delete2);
        ps.setInt(1, guiaDespedido.getNGuia());
        ps2.setString(1, guiaDespedido.getDNI());
        ps.execute();
        ps2.execute();

    }

    // ############################# EMPLEADOS #############################
    private List cargarEmpleados() throws SQLException {
        List empleados = new ArrayList();
        String query = "SELECT persona.nombre, guia.dniGuia, persona.telefono, guia.numSeguridadSocial, guia.numIdentificacion, guia.numGuia "
                + "FROM persona, guia WHERE guia.dniGuia = persona.dni";

        PreparedStatement ps = ConexionBD.instancia().getConnection().prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            empleados.add(new Guia(rs.getString("persona.nombre"), rs.getString("guia.dniGuia"),
                    rs.getInt("persona.telefono"), rs.getLong("guia.numSeguridadSocial"),
                    rs.getInt("guia.numIdentificacion"), rs.getInt("guia.numGuia")));
        }

        return empleados;
    }

    // ############################# EXPOSICIÓN #############################
    public boolean existeExposicion(String nombre) throws SQLException {
        boolean existe = false;
        String query = "SELECT * FROM exposicion WHERE nombre = ?";

        PreparedStatement ps = ConexionBD.instancia().getConnection().prepareStatement(query);
        ps.setString(1, nombre);

        ResultSet rs = ps.executeQuery();
        // Si hay siguiente es que existe al menos una entrada en la tabla
        if (rs.next()) {
            existe = true;
        }

        return existe;
    }

    public void nuevaExposicion(Exposicion e) throws SQLException {
        String insert = "INSERT INTO exposicion (nombre, tiempoRecorrido, imagen) VALUES (?, ?, ?)";

        PreparedStatement ps = ConexionBD.instancia().getConnection().prepareStatement(insert);
        ps.setString(1, e.getNombre());
        ps.setInt(2, e.getTiempoRecorrido());
        ps.setString(3, e.getRutaImagen());

        // Se ejecuta el insert
        ps.executeUpdate();
    }

    public void eliminarExposicion(int id) throws SQLException {
        String delete = "DELETE FROM exposicion WHERE idExposicion = ?";

        PreparedStatement ps = ConexionBD.instancia().getConnection().prepareStatement(delete);
        ps.setInt(1, id);

        // Se ejecuta el delete
        ps.executeUpdate();
    }

    public Exposicion cargarExposicion(int id) throws SQLException {
        Exposicion e = null;
        String query = "SELECT nombre, tiempoRecorrido, imagen FROM exposicion WHERE idExposicion = ?";

        PreparedStatement ps = ConexionBD.instancia().getConnection().prepareStatement(query);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            e = new Exposicion(id, rs.getString("nombre"), rs.getInt("tiempoRecorrido"), rs.getString("imagen"), cargarObrasExposicion(id));
        }

        return e;
    }

    public Exposicion cargarExposicion(String nombre) throws SQLException {
        Exposicion e = null;
        String query = "SELECT * FROM exposicion WHERE nombre = ?";

        PreparedStatement ps = ConexionBD.instancia().getConnection().prepareStatement(query);
        ps.setString(1, nombre);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            e = new Exposicion(rs.getInt("idExposicion"), rs.getString("nombre"), rs.getInt("tiempoRecorrido"),
                    rs.getString("imagen"), cargarObrasExposicion(rs.getInt("idExposicion")));
        }

        return e;
    }

    private List cargarExposiciones() throws SQLException {
        List exposiciones = new ArrayList();
        String query = "SELECT idExposicion, nombre, tiempoRecorrido, imagen FROM exposicion";

        PreparedStatement ps = ConexionBD.instancia().getConnection().prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            exposiciones.add(new Exposicion(rs.getInt("idExposicion"), rs.getString("nombre"),
                    rs.getInt("tiempoRecorrido"), rs.getString("imagen"), cargarObrasExposicion(rs.getInt("idExposicion"))));
        }

        return exposiciones;
    }

    // ############################# OBRA #############################
    public boolean existeObra(String titulo, String autor, String anno, String tipo) throws SQLException {
        boolean existe = false;
        String query = "SELECT * FROM obra WHERE titulo = ? AND autor = ? AND año = ? AND tipo = ?";

        PreparedStatement ps = ConexionBD.instancia().getConnection().prepareStatement(query);
        ps.setString(1, titulo);
        ps.setString(2, autor);
        ps.setString(3, anno);
        ps.setString(4, tipo);

        ResultSet rs = ps.executeQuery();
        // Si hay siguiente es que existe al menos una entrada en la tabla
        if (rs.next()) {
            existe = true;
        }

        return existe;
    }

    public void nuevaObra(Obra o) throws SQLException {
        String insert = "INSERT INTO obra (titulo, autor, estilo, año, tipo, imagen) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = ConexionBD.instancia().getConnection().prepareStatement(insert);
        ps.setString(1, o.getTitulo());
        ps.setString(2, o.getAutor());
        ps.setString(3, o.getEstilo());
        ps.setString(4, o.getAnno());
        ps.setString(5, o.getTipo());
        ps.setString(6, o.getRutaImagen());

        // Se ejecuta el insert
        ps.executeUpdate();
    }

    public void eliminarObra(int id) throws SQLException {
        String delete = "DELETE FROM obra WHERE idObra = ?";

        PreparedStatement ps = ConexionBD.instancia().getConnection().prepareStatement(delete);
        ps.setInt(1, id);

        // Se ejecuta el delete
        ps.executeUpdate();
    }

    public Obra cargarObra(int id) throws SQLException {
        Obra o = null;
        String query = "SELECT titulo, autor, estilo, año, tipo, imagen FROM obra WHERE idObra = ?";

        PreparedStatement ps = ConexionBD.instancia().getConnection().prepareStatement(query);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            o = new Obra(id, rs.getString("titulo"), rs.getString("autor"), rs.getString("estilo"),
                    rs.getString("año"), rs.getString("tipo"), rs.getString("imagen"));
        }

        return o;
    }

    public Obra cargarObra(String titulo, String autor) throws SQLException {
        Obra o = null;
        String query = "SELECT idObra, titulo, autor, estilo, año, tipo, imagen FROM obra WHERE titulo = ? AND autor = ?";

        PreparedStatement ps = ConexionBD.instancia().getConnection().prepareStatement(query);
        ps.setString(1, titulo);
        ps.setString(2, autor);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            o = new Obra(rs.getInt("idObra"), rs.getString("titulo"), rs.getString("autor"), rs.getString("estilo"),
                    rs.getString("año"), rs.getString("tipo"), rs.getString("imagen"));
        }

        return o;
    }

    private List cargarObrasExposicion(int idExpo) throws SQLException {
        List obras;
        String query = "SELECT obra.* FROM obra, exposicion, exposicion_obra WHERE obra.idObra = exposicion_obra.idObra "
                + "AND exposicion.idExposicion = exposicion_obra.idExposicion AND exposicion.idExposicion = ?";

        PreparedStatement ps = ConexionBD.instancia().getConnection().prepareStatement(query);
        ps.setInt(1, idExpo);

        // Se ejecuta la query
        ResultSet rs = ps.executeQuery();
        obras = new ArrayList();

        while (rs.next()) {
            obras.add(new Obra(rs.getInt("idObra"), rs.getString("titulo"), rs.getString("autor"), rs.getString("estilo"),
                    rs.getString("año"), rs.getString("tipo"), rs.getString("imagen")));
        }

        return obras;
    }

    // ############################# ENTRADAS #############################
    // Inserta los datos de la entrada reservada en la base de datos
    public void reservarEntradaNormal(Entrada e, Cliente c) throws SQLException {
        String insert = "INSERT INTO entrada (fechaReserva, hora, guiada, idCliente) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = ConexionBD.instancia().getConnection().prepareStatement(insert);
        ps.setDate(1, new java.sql.Date(e.getFecha().getTime()));
        ps.setString(2, e.getHora());
        ps.setBoolean(3, e.getEsGuiada());
        ps.setInt(4, c.getIdCliente());

        // Se ejecuta el insert
        ps.executeUpdate();
    }

    // En el caso de que sea guiada se insertarán los datos del guía en otra tabla a mayores
    public void reservarEntradaGuiada(Entrada e, Cliente c) throws SQLException {
        String insert1 = "INSERT INTO entrada (fechaReserva, hora, guiada, precio, idCliente) VALUES (?, ?, ?, ?, ?)";
        float precioEntrada = devolverPrecioEntrada();
        float precioSuplemento = devolverPrecioSuplemento();
        float precioTotal = precioEntrada + precioSuplemento; // Precio total de la entrada

        // Inserción en la tabla entrada
        PreparedStatement ps1 = ConexionBD.instancia().getConnection().prepareStatement(insert1);
        ps1.setDate(1, new java.sql.Date(e.getFecha().getTime()));
        ps1.setString(2, e.getHora());
        ps1.setBoolean(3, e.getEsGuiada());
        ps1.setFloat(4, precioTotal);
        ps1.setInt(5, c.getIdCliente());
        // Se ejecuta el insert
        ps1.executeUpdate();
    }

    // Recoge los datos de las entradas reservados por un cliente determinado
    public List cargarEntradasCliente(int idCliente) throws SQLException {
        List entradas = new ArrayList();

        String query1 = "SELECT numeroEntrada, fechaReserva, hora, "
                + "guiada, precio, idCliente FROM entrada WHERE entrada.idCliente = ?";

        PreparedStatement ps1 = ConexionBD.instancia().getConnection().prepareStatement(query1);
        ps1.setInt(1, idCliente);

        ResultSet rs1 = ps1.executeQuery();

        while (rs1.next()) {
            entradas.add(new Entrada(rs1.getInt("numeroEntrada"),
                    rs1.getDate("fechaReserva"), rs1.getString("hora"),
                    rs1.getBoolean("guiada"), rs1.getFloat("precio"),
                    rs1.getInt("idCliente")));
        }

        return entradas;
    }

    // Cambia el precio general de la entrada (exclusivo para el administrador)
    public void cambiarPrecioEntrada(float precioEntrada) throws SQLException {
        String alter = "ALTER TABLE entrada ALTER precio SET DEFAULT ?";
        PreparedStatement ps = ConexionBD.instancia().getConnection().prepareStatement(alter);
        ps.setFloat(1, precioEntrada);

        // Se ejecuta el comando SQL para establecer el valor por defecto a la columna
        ps.execute();
    }

    // Cambia el precio del suplemento del guía (exclusivo para el administrador)
    public void cambiarPrecioSuplemento(float precioSuplemento) throws SQLException {
        String alter = "ALTER TABLE entrada ALTER suplementoGuia SET DEFAULT ?";
        PreparedStatement ps = ConexionBD.instancia().getConnection().prepareStatement(alter);
        ps.setFloat(1, precioSuplemento);
        // Se ejecuta el comando SQL para establecer el valor por defecto a la columna
        ps.execute();
    }

    // Obtiene el precio de la entrada en el momento de ejecución
    public float devolverPrecioEntrada() throws SQLException {
        float precioEntrada = 0;
        String query = "SELECT COLUMN_DEFAULT from INFORMATION_SCHEMA.COLUMNS "
                + "WHERE TABLE_SCHEMA='2CygLOTEPa' AND TABLE_NAME='entrada' "
                + "AND COLUMN_NAME='precio'";

        PreparedStatement ps = ConexionBD.instancia().getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            precioEntrada = rs.getFloat("COLUMN_DEFAULT");
        }

        return precioEntrada;
    }

    // Obtiene el precio del suplemento por el guía en el momento de ejecución
    public float devolverPrecioSuplemento() throws SQLException {
        float precioSuplemento = 0;
        String query = "SELECT COLUMN_DEFAULT from INFORMATION_SCHEMA.COLUMNS "
                + "WHERE TABLE_SCHEMA='2CygLOTEPa' AND TABLE_NAME='entrada' "
                + "AND COLUMN_NAME='suplementoGuia'";

        PreparedStatement ps = ConexionBD.instancia().getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            precioSuplemento = rs.getFloat("COLUMN_DEFAULT");
        }

        return precioSuplemento;
    }

    // Obtiene el número de la entrada en el momento de ejecución
    private int obtenerNumEntradaActual() throws SQLException {
        int numEntradaActual = -1;
        String query = "SELECT MAX(numeroEntrada) FROM entrada";

        PreparedStatement ps = ConexionBD.instancia().getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            numEntradaActual = rs.getInt("MAX(numeroEntrada)");
        }

        return numEntradaActual;
    }
}
