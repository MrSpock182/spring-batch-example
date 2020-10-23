package br.com.alura.springbatch.service;

import org.springframework.stereotype.Service;

@Service
public class EnviaEmail {
    public void envio() {
        System.out.println("Enviado email");
    }
}
