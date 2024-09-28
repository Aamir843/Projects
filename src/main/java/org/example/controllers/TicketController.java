package org.example.controllers;

import org.example.dtos.GenerateTicketRequestDto;
import org.example.dtos.GenerateTicketResponseDto;
import org.example.exceptions.NoParkingSpotFoundException;
import org.example.enums.ResponseStatus;
import org.example.models.Ticket;
import org.example.services.TicketService;

public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto ticketRequestDto){

        GenerateTicketResponseDto generateTicketResponseDto=new GenerateTicketResponseDto();

        try{
            Ticket ticket=ticketService.generateTicket(ticketRequestDto.getVehicleNumber(),
                    ticketRequestDto.getGateId(),ticketRequestDto.getVehicleType());

            generateTicketResponseDto.setTicket(ticket);
            generateTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (NoParkingSpotFoundException e) {
            generateTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return generateTicketResponseDto;
    }
}
