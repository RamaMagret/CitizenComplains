package com.rama.services.ClaimServiceImp;

import com.rama.model.claims;
import com.rama.repository.ClaimsRepository;
import com.rama.services.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesImp implements ClaimService {
    @Autowired
    ClaimsRepository designrepo;
    @Override
    public claims saveDesign(claims claims) {
        return designrepo.save(claims);
    }

    @Override
    public claims updateDesign(claims claims) {
      return designrepo.save(claims);
    }

    @Override
    public claims findDesign(String id) {

        return designrepo.findById(id).get();
    }

    @Override
    public List<claims> getAllDesigns() {
        return designrepo.findAll();
    }

    @Override
    public void deleteDesign(String desing) {
        designrepo.deleteById(desing);
    }
}
