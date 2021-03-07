package com.company.repositories.interfaces;

import com.company.entities.Necklace;
import com.company.entities.Stone;


import java.util.List;

public interface INecklaceRepo {
    boolean createNecklace(Necklace necklace);
    Necklace getNecklaceById(int id);
    List<Stone> getStonesByOrder(int id);
    List<Necklace> getAllNecklaces();
    boolean UpdateNecklaceById(int id);
}
