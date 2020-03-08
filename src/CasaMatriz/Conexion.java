package CasaMatriz;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.net.Socket;
import java.util.ArrayList;


/**
 *
 * @author SrDeLorean
 */
public class Conexion {
    
    private ArrayList<EstacionDeServicio> estacionesdeservicio;
    private int puerto;
    private DataInputStream dis;
    private DataOutputStream out;
    private ArrayList<String[]> informe;
    private Double litrosConsumidos=0.0;
    private int cantidadDeCargas=0;
    
    public Conexion(int puerto) {
        this.estacionesdeservicio = new ArrayList<>();
        this.puerto = puerto;
    }
    
    
    public void editarInformacionDelPrecioDeUnaEstacion(int idEstacion, Precios precios) throws IOException{
        Socket socket;
        socket=new Socket(this.estacionesdeservicio.get(idEstacion).getIp(), this.estacionesdeservicio.get(idEstacion).getPuerto());
        DataInputStream inSocket = new DataInputStream(socket.getInputStream());
        DataOutputStream outSocket= new DataOutputStream(socket.getOutputStream()); 
        outSocket.writeInt(1);
        outSocket.writeDouble(precios.getB93());
        outSocket.writeDouble(precios.getB95());
        outSocket.writeDouble(precios.getB97());
        outSocket.writeDouble(precios.getDisel());
        outSocket.writeDouble(precios.getKerosene());
        inSocket.close();
        outSocket.close();
        socket.close();
    }

    public void editarInformacionDelPrecioDeTodasLasEstaciones(Precios precios) throws IOException {
        for (int i=0; i<this.estacionesdeservicio.size(); i++) {
            Socket socket;
            socket=new Socket(this.estacionesdeservicio.get(i).getIp(), this.estacionesdeservicio.get(i).getPuerto());
            DataInputStream inSocket = new DataInputStream(socket.getInputStream());
            DataOutputStream outSocket= new DataOutputStream(socket.getOutputStream()); 
            outSocket.writeInt(1);
            outSocket.writeDouble(precios.getB93());
            outSocket.writeDouble(precios.getB95());
            outSocket.writeDouble(precios.getB97());
            outSocket.writeDouble(precios.getDisel());
            outSocket.writeDouble(precios.getKerosene());
            inSocket.close();
            outSocket.close();
            socket.close();
        }
    }
   
    public void obtenerInformacionDeLaEstacion(int idEstacion,String tipoCombustible) throws IOException{
        Socket socket;
        socket=new Socket(this.estacionesdeservicio.get(idEstacion).getIp(), this.estacionesdeservicio.get(idEstacion).getPuerto());
        DataInputStream inSocket = new DataInputStream(socket.getInputStream());
        DataOutputStream outSocket= new DataOutputStream(socket.getOutputStream()); 
        //outSocket.writeUTF("Se escucha server");
        //System.out.println(inSocket.readUTF());
        outSocket.writeInt(2);
        outSocket.writeUTF(tipoCombustible);
        int cantidadCompras = inSocket.read();
        informe = new ArrayList<>();
        if (cantidadCompras!= 0) {
            for (int i = 0; i < cantidadCompras; i++) {
                String [] compra = new String[5];
                compra[0] = Integer.toString(inSocket.readInt());
                compra[1] = Integer.toString(inSocket.readInt());
                compra[2] = inSocket.readUTF();
                compra[3] = String.valueOf(inSocket.readDouble());
                compra[4] = Integer.toString(inSocket.readInt());
                informe.add(compra);
            }
        }
        litrosConsumidos=inSocket.readDouble();
        cantidadDeCargas=inSocket.readInt();
        System.out.println("litrosConsumidos" + litrosConsumidos);
        System.out.println("cantidadDeCargas" +cantidadDeCargas);
        inSocket.close();
        outSocket.close();
        socket.close();
        
    }
   
    
    public void test() throws IOException{
        Socket socket;
        socket=new Socket(this.estacionesdeservicio.get(0).getIp(), this.estacionesdeservicio.get(0).getPuerto());
        DataInputStream inSocket = new DataInputStream(socket.getInputStream());
        DataOutputStream outSocket= new DataOutputStream(socket.getOutputStream()); 
        outSocket.writeUTF("Se escucha server");
        System.out.println(inSocket.readUTF());
        inSocket.close();
        outSocket.close();
        socket.close();
    }

    public ArrayList<EstacionDeServicio> getEstacionesdeservicio() {
        return estacionesdeservicio;
    }

    public void agregarConexion(String id, String direccion, String ip) {
        this.estacionesdeservicio.add(new EstacionDeServicio(Integer.parseInt(id),direccion,ip,puerto));
    }

    public ArrayList<String[]> getInforme() {
        return informe;
    }

    public Double getLitrosConsumidos() {
        return litrosConsumidos;
    }

    public int getCantidadDeCargas() {
        return cantidadDeCargas;
    }
    
    
}
