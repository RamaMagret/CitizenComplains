package com.rama.services;



import com.rama.model.claims;

import java.util.List;

public interface ClaimService {
    public claims saveDesign(claims claims);
    public claims updateDesign(claims claims);
    public claims findDesign(String id);
    public List<claims> getAllDesigns();
    public void deleteDesign(String id);
}
