import javax.swing.JOptionPane;

public class App extends javax.swing.JFrame{
    public int codigo;
    public String nombre;
    public double precio;
    public int inventario;
    Producto Productos[];
    BaseDatosProductos bdProductos = new BaseDatosProductos();
    public App(){
        initComponents();

        this.tabla.setModel(new TablaModelProducto(bdProductos.getListaProductos()));
    }

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt){
        if(validarDatos()){
            if(!bdProductos.verificarExistencias(nombre)){
                if(codigo == 0)    {
                    int codigoAux = bdProductos.ultimoCodigo() + 1;
                    bdProductos.agregar(new Producto(codigoAux, nombre, precio, inventario));
                    this.tabla.setModel(new TablaModelProducto(bdProductos.getListaProductos()));
                    limpiarDatos();
                    JOptionPane.showMessageDialog(this,"Producto agregado exitosamente", "Confirmacion", 1);

                }else{
                    JOptionPane.showMessageDialog(this,"imposible agregar esta accion es permitida para Actualizar o borrar", "Advertencia", 2);

                }
            }else{
                JOptionPane.showMessageDialog(this,"El producto ya existe", "Advertencia", 2);

            }
        } else{
            JOptionPane.showMessageDialog(this,"Algunos de los valores esta vacio o es erroneo", "Advertencia", 2);
        }
    }

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {                                   
        Producto producto = ((TablaModelProducto) this.tabla.getModel()).detalle(this.tabla.getSelectedRow());
        this.txtCodigo.setText(String.valueOf(producto.getCodigo()));
        this.txtNombre.setText(producto.getNombre());
        this.txtPrecio.setText(String.valueOf(producto.getPrecio()));
        this.txtInventario.setText(String.valueOf(producto.getInventario()));
    } 

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {                                                
         if(validarDatos()){
            bdProductos.actualizar(new Producto(codigo,nombre,precio,inventario));
            this.tabla.setModel(new TablaModelProducto(bdProductos.getListaProductos()));
            limpiarDatos();
            JOptionPane.showMessageDialog(this,"Producto Actualizado exitosamente", "Confirmacion", 1);
         }else{
            JOptionPane.showMessageDialog(this,"Algunos de los valores esta vacio o es erroneo", "Advertencia", 2);
         }
    }  

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        if(validarDatos()){
            bdProductos.borrar(new Producto(codigo,nombre,precio,inventario));
            this.tabla.setModel(new TablaModelProducto(bdProductos.getListaProductos()));
            limpiarDatos();
            JOptionPane.showMessageDialog(this,"Producto Eliminado exitosamente", "Confirmacion", 1);
         
        }else{
            JOptionPane.showMessageDialog(this,"Algunos de los valores esta vacio o es erroneo", "Advertencia", 2);
            
        }
    } 

    private void botonInformeActionPerformed(java.awt.event.ActionEvent evt) {                                             
        JOptionPane.showMessageDialog(this,bdProductos.generarInforme(), "Advertencia", 2);

    }  

    public boolean validarDatos(){
        try {
            codigo = Integer.parseInt(("".equals(txtCodigo.getText())  ? "0" : txtCodigo.getText()));
            nombre = txtNombre.getText();
            precio = Double.parseDouble(txtPrecio.getText());
            inventario = Integer.parseInt(txtInventario.getText());
            return true;

        } catch (Exception e) {
            return false;
        }
    }
    public void limpiarDatos(){
        this.txtCodigo.setText("");
        this.txtNombre.setText("");
        this.txtPrecio.setText("");
        this.txtInventario.setText("");
    }

    private void initComponents(){
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtInventario = new javax.swing.JTextField();
        botonAgregar = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        botonInforme = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));

        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Inventario Ferreteria");

        jLabel2.setText("Agregar Producto");

        jLabel3.setText("Codigo:");

        txtCodigo.setEnabled(false);
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        jLabel4.setText("Nombre:");

        jLabel5.setText("Precio:");

        jLabel6.setText("Inventario:");

        botonAgregar.setText("Agregar");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        botonActualizar.setText("Actualizar");

        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        botonEliminar.setText("Eliminar");

        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        jLabel7.setText("Lista productos");

        botonInforme.setText("Informe");

        botonInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInformeActionPerformed(evt);
            }
        });

        jLabel8.setText("*Seleccione el dato de la tabla que desea actualizar o eliminar");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });

        jScrollPane2.setViewportView(tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonAgregar)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(107, 107, 107)
                                .addComponent(botonInforme))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonActualizar)))
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonEliminar)
                        .addComponent(botonActualizar)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(botonInforme))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addComponent(botonAgregar)
                        .addContainerGap(244, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();


    }

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }
    
    public static void main(String[] args) throws Exception {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonInforme;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtInventario;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;














    
}
