/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conu.conuwebserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author JuanArevaloMerchan y Stefany Moron
 */
@SpringBootApplication
@ComponentScan(basePackages = {"conu.conuwebserver"})
public class API {
    public static void main(String[] args) {
	SpringApplication.run(API.class, args);
    }
}
