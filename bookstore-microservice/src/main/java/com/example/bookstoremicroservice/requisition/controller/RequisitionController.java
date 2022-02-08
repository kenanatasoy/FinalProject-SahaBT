package com.example.bookstoremicroservice.requisition.controller;

import com.example.bookstoremicroservice.requisition.dto.request.RequisitionRequest;
import com.example.bookstoremicroservice.requisition.dto.response.RequisitionResponse;
import com.example.bookstoremicroservice.requisition.service.RequisitionService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestScope
@RequestMapping("requisitions")
@CrossOrigin
public class RequisitionController {

    private final RequisitionService requisitionService;

    public RequisitionController(RequisitionService requisitionService) {
        this.requisitionService = requisitionService;
    }

    @PostMapping("makeRequisition")
    public RequisitionResponse makeRequisition(
            @RequestBody RequisitionRequest requisitionRequest){
        return requisitionService.makeRequisition(requisitionRequest).get();
    }

    @PostMapping("makeImmediateRequisition")
    public RequisitionResponse makeImmediateRequisition(
            @RequestBody RequisitionRequest requisitionRequest){
        return requisitionService.makeImmediateRequisition(requisitionRequest).get();
    }

    @GetMapping("{requisitionId}")
    public RequisitionResponse getRequisitionById(@PathVariable long requisitionId) {
        return requisitionService.findRequisitionById(requisitionId);
    }

    @GetMapping("requisitions")
    public List<RequisitionResponse> getAllRequisitions(){
        return requisitionService.findAllRequisitions();
    }

    @DeleteMapping("{requisitionId}")
    public void clearRequisition(@PathVariable long requisitionId){
        requisitionService.clearRequisition(requisitionId);
    } //TODO should return RequisitionResponse not void

    @GetMapping("{publisherId}")
    public List<RequisitionResponse> getRequisitionsByPublisherId(@PathVariable long publisherId){
        return requisitionService.findRequisitionsByPublisherId(publisherId);
    }

}
