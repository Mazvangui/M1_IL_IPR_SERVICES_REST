package fr.istic.rest;

import fr.istic.chat.message.*;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

@Path("/messages")
public class MessageRessource {

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Message> getMessages(){
        return MessageList.getInstance().getMessages();
    }

    @Path("/after/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Message> getMessagesAfter(@PathParam("id") Long id){
        return MessageList.getInstance().getMessagesAfter(id);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Message createMessages(JAXBElement<Message> message){
        return MessageList.getInstance().createMessage(message.getValue());
    }

    @Path("/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Message getMessage(@PathParam("id") Long id) {
        return MessageList.getInstance().getMessage(id);
    }

    @Path("/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public void deteleMessage(@PathParam("id") Long id) {
        MessageList.getInstance().delMessage(id);
    }
}