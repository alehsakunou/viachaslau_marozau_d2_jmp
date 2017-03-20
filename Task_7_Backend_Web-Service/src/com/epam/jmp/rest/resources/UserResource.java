package com.epam.jmp.rest.resources;

import com.epam.jmp.rest.beans.User;
import com.epam.jmp.rest.services.interfaces.UserService;
import com.epam.jmp.rest.services.impl.SimpleCacheUserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by Viachaslau_Marozau on 3/19/2017.
 */
@Path("user")
public class UserResource
{
    private final static UserService userService = new SimpleCacheUserService();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<User> getUser()
    {
        return userService.getAllUsers();
    }

    @GET
    @Path("/{login}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getUserByName(@PathParam("login") String login)
    {
        if (login == null || login.isEmpty())
            return Response.status(Response.Status.BAD_REQUEST).build();

        User user = userService.getUser(login);
        if (user == null)
            return Response.status(Response.Status.NOT_FOUND)
                .entity("User does not exist [" + login + "]")
                .build();

        return Response.ok(user).build();
    }

    @PUT
    @Path("/{login}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response updateUser(@PathParam("login") String login,
        User user)
    {
        if (login == null || login.isEmpty())
            return Response.status(Response.Status.BAD_REQUEST).build();
        if (user == null)
            return Response.status(Response.Status.BAD_REQUEST).build();

        User existUser = userService.getUser(login);
        if (existUser == null)
            return Response.status(Response.Status.NOT_FOUND)
                .entity("User does not exist [" + login + "]")
                .build();

        User resultUser = userService.update(user);
        return Response.ok().entity(resultUser).build();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response addUser(
        User user)
        throws URISyntaxException
    {
        if (user == null)
            return Response.status(Response.Status.BAD_REQUEST).build();

        User existUser = userService.getUser(user.getLogin());
        if (existUser != null)
            return Response.status(Response.Status.BAD_REQUEST)
                .entity("User is already exist [" + user.getLogin() + "]")
                .build();

        User resultUser = userService.add(user);
        return Response.created(new URI("/user/" + user.getLogin())).entity(resultUser).build();
    }

    @DELETE
    @Path("/{login}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response deleteUser(
        @PathParam("login")
            String login)
    {
        if (login == null || login.isEmpty())
            return Response.status(Response.Status.BAD_REQUEST).build();

        User existUser = userService.getUser(login);
        if (existUser == null)
            return Response.status(Response.Status.NOT_FOUND)
                .entity("User does not exist [" + login + "]")
                .build();
        userService.delete(login);
        return Response.ok().build();
    }
}
