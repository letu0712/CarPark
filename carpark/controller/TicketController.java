package com.example.carpark.controller;

import com.example.carpark.entity.Ticket;
import com.example.carpark.service.TicketService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    //select all
    @GetMapping
    public ResponseEntity<List<Ticket>> selectAllTicket(){
        return ResponseEntity.ok(ticketService.selectAllTicket());
    }

    //select by id
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> selectById(@PathVariable("id") long id){
        return ResponseEntity.ok(ticketService.selectById(id));
    }

    //Add ticket
    @PostMapping
    public ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket){
        return ResponseEntity.ok(ticketService.addTicket(ticket));
    }
}
