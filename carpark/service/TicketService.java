package com.example.carpark.service;

import com.example.carpark.entity.Ticket;
import com.example.carpark.exception.NotFoundException;
import com.example.carpark.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    //select all
    public List<Ticket> selectAllTicket(){
        if(ticketRepository.findAll().size() > 0){
            return ticketRepository.findAll();
        }else{
            throw new NotFoundException("Ticket not found");
        }
    }

    //select by Id
    public Ticket selectById(long id){
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        if(ticketOptional.isPresent()){
            return ticketOptional.get();
        }else{
            throw new NotFoundException("Ticket id="+id+" not found");
        }
    }

    //Add ticket
    public Ticket addTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    //Delete ticket theo Id
    public void deleteTicket(long id){
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        if(ticketOptional.isPresent()){
            ticketRepository.deleteById(id);
        }else{
            throw new NotFoundException("Ticket id="+id+" not found");
        }
    }
}
