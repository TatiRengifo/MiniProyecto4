import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BaseDatosProductos {
    private HashMap<Integer, Producto> listaProductos = new HashMap<>();

    public BaseDatosProductos() {
        this.listaProductos.put(1, new Producto(1,"Tornillos",8000,65));
        this.listaProductos.put(2,new Producto(2, "Martillo", 15000, 30));
        this.listaProductos.put(3,new Producto(3, "Clavos", 5000, 150));
        this.listaProductos.put(4,new Producto(4, "Destornillador", 10000, 25));
        this.listaProductos.put(5,new Producto(5, "Llave Inglesa", 12000, 20));
        this.listaProductos.put(6,new Producto(6, "Sierra", 25000, 10));
        this.listaProductos.put(7,new Producto(7, "Cinta Métrica", 7000, 40));
        this.listaProductos.put(8,new Producto(8, "Pegamento", 6000, 50));
        this.listaProductos.put(9,new Producto(9, "Escalera", 35000, 5));
        this.listaProductos.put(10,new Producto(10, "Nivel", 9000, 15));
    
    }

    public List<Producto> getListaProductos() {
        return new ArrayList<>(this.listaProductos.values());
    }

    public void setListaProductos(HashMap<Integer, Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public boolean verificarExistencias(Producto producto) {
        return this.listaProductos.containsKey(producto.getCodigo());
    }

    public boolean verificarExistencias(String nombre){
        for (Producto p : this.listaProductos.values()) {
            if(nombre.toLowerCase().equals(p.getNombre().toLowerCase())){ 
                return true;
            }
        }
        return false;
    }

    public int ultimoCodigo(){
        int codigo = 0;
        for (Producto p : this.listaProductos.values()) {
            codigo = p.getCodigo();        
        }
        return codigo;
    }

    public void agregar(Producto p){
        this.listaProductos.put(p.getCodigo(), p);

    }

    public void actualizar(Producto p){
        this.listaProductos.replace(p.getCodigo(),p);

    }

    public void borrar(Producto p){
        this.listaProductos.remove(p.getCodigo());
    }

    public String generarInforme(){
        List<Producto> listaM = obtenerMayores();
        return listaM.get(0).getNombre()+" "+listaM.get(1).getNombre()+""+listaM.get(2).getNombre();
    }

    private List<Producto> obtenerMayores(){
        List<Producto> lista = new ArrayList<>(this.listaProductos.values());
        List<Producto> listaMayores = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            Producto p = new Producto();
            for (Producto pTemp : lista){
                if ( pTemp.getPrecio() > p.getPrecio()){
                    p = pTemp;
                }
            }
            listaMayores.add(p);
            lista.remove(p);
        }
        return listaMayores;
    }




}
