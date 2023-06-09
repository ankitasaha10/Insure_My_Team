package com.example.Insure.My.Team.Controller;


import com.example.Insure.My.Team.DTO.InsurancePolicyDTO;
import com.example.Insure.My.Team.Models.InsurancePolicy;
import com.example.Insure.My.Team.Service.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class InsurancePolicyController {

    @Autowired
    InsurancePolicyService insurancePolicyService;

    @PostMapping
    public String addPolicy(@RequestBody InsurancePolicyDTO insurancePolicyDTO){

        return insurancePolicyService.addPolicy(insurancePolicyDTO);
    }

    @GetMapping
    public List<InsurancePolicy> getAllInsurancePolicies(){
        return insurancePolicyService.getAllInsurancePolicies();
    }

    @GetMapping("/{id}")
    public InsurancePolicy getInsurancePolicyById(@PathVariable int id){
        return insurancePolicyService.getInsurancePolicyById(id);
    }


    //Used exception handling in case of incorrect id
    @DeleteMapping("/{id}")
    public String deleteInsurancePolicy(@PathVariable int id) {
        try {
            return insurancePolicyService.deleteInsurancePolicy(id);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PutMapping("/{id}")
    public String updateCoverageAmount(@PathVariable int id, @RequestParam ("coverageAmount") String coverageAmount){

        return insurancePolicyService.updateInsurancePolicy(id,coverageAmount);
    }

}
