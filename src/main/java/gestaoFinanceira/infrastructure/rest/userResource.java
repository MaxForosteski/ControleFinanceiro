/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaoFinanceira.infrastructure.rest;

/**
 *
 * @author Everto_Clewito_Riber
 */
import gestaoFinanceira.application.user.UserService;
import gestaoFinanceira.domain.user.User;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/User")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class userResource {

    @Inject
    private UserService userService; 
    

    @GET
    public List<User> userListAll() {
        return userService.userListAllWrapper();
    }

    @GET
    @Path("/{id}")
    public Response findUserById(@PathParam("id") Long id) {
        User user = userService.userByIdWrapper(id);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(user).build();
    }

    @POST
    public Response createUser(User user) {
        userService.createUserWrapper(user);
        return Response.status(Response.Status.CREATED).entity(user).build();
    }

    @PUT
    public Response updateUser(User updatedUser) {
        User user = userService.userByIdWrapper(updatedUser.getId());
        if(user == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        userService.updateUserWrapper(updatedUser);
        return Response.ok(updatedUser).build();
        
    }
    
    @PUT
    @Path("/{id}")
    public Response logicalDeleteUser(@PathParam("id") Long id){
        User user = userService.userByIdWrapper(id);
        if(user == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        user.setIsActive(false);
        userService.updateUserWrapper(user);
        return Response.ok(user).build();
    }
}
