/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.Cliente;

/**
 *
 * @author jgasd
 */
@Stateless
@Path("modelo.cliente")
public class ClienteFacadeREST extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "proyecfinalPU")
    private EntityManager em;

    public ClienteFacadeREST() {
        super(Cliente.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Cliente entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Cliente entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Cliente find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cliente> findAll() {
        return super.findAll();
    }
    
    /////////////Trabajo del debre////////////////
    
    @POST
    @Path ("CrearCliente")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String crear(@FormParam("ide")String ide,@FormParam("cedula")String cedula,@FormParam("nombre")String nombre,@FormParam("apellido")String apellido,
    @FormParam("direccion")String direccion,@FormParam("correo")String correo,@FormParam("telefono")String telefono,@FormParam("ciudad") String ciudad,@FormParam("edad")
    String edad,@FormParam("joyeriapref") int joyeriapref){
     
     Cliente ob = new Cliente(ide, cedula, nombre, apellido, direccion, correo, telefono, ciudad, edad, joyeriapref);
     super.create(ob);     
      return "Se registro correctamente";  
    }
    
    @POST
      @Path ("Actualizardatos")
      @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
       public String actualizar(@FormParam("ide")String ide,@FormParam("cedula")String cedula,@FormParam("nombre")String nombre,@FormParam("apellido")String apellido,
    @FormParam("direccion")String direccion,@FormParam("correo")String correo,@FormParam("telefono")String telefono,@FormParam("ciudad") String ciudad,@FormParam("edad")
    String edad,@FormParam("joyeria_Pref") int joyeriapref){
    
           Cliente ob = new Cliente(ide);
           ob.setNombre(nombre);
           ob.setApellido(apellido);
           ob.setDireccion(direccion);
           ob.setCorreo(correo);
           ob.setTelefono(telefono);
           ob.setCiudad(ciudad);
           ob.setEdad(edad);
           ob.setJoyeriapref(joyeriapref);
           super.edit(ob);
           
        return "Se edito correctamente";
    }
              @POST
       @Path ("Eliminar")
       @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
       public String eliminar(@FormParam("ide")String ide){
          Cliente ob = super.find(ide);
          super.remove(ob);
          return "se elimino correctamente";
           
       } 
@POST
@Path ("buscar")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
public List <Cliente> bus(@FormParam("joyeriapref")int joyeriapref){
 
    TypedQuery consulta = getEntityManager().createQuery("SELECT c FROM Cliente c WHERE c.joyeriapref = :joyeriapref",Cliente.class);
    consulta.setParameter("joyeriapref",joyeriapref);
    return consulta.getResultList();
}

@POST
@Path ("buscarmayores")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
public List <Cliente> bus(@FormParam("mayores")String mayor){
 
    TypedQuery consulta = getEntityManager().createQuery("SELECT c FROM Cliente c WHERE c.edad > :edad",Cliente.class);
       
    consulta.setParameter("edad",mayor);
    
    return consulta.getResultList();
}


///////////////////////////////////////////////////

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cliente> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
