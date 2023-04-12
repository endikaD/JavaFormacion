package com.example.Example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Servicio{
    private Persona persona;

    HashMap<String,String > hashMap = new HashMap<String, String >();

    public HashMap addVar(String var1, String var2){
        hashMap.put("var1",var1);
        hashMap.put("var2",var2);
        return hashMap;

    }
}
