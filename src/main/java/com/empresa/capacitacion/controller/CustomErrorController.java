package com.empresa.capacitacion.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador para manejar errores HTTP (404, 500, 403) de forma amigable.
 * Reemplaza la "Whitelabel Error Page" por defecto de Spring Boot.
 */
@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        
        String titulo = "Error Inesperado";
        String mensaje = "Ha ocurrido un error en la aplicación.";

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == 404) {
                titulo = "Página no encontrada (404)";
                mensaje = "Lo sentimos, la ruta que buscas no existe o ha sido movida.";
            } else if (statusCode == 500) {
                titulo = "Error Interno del Servidor (500)";
                mensaje = "Algo salió mal en nuestro lado. Por favor, intenta más tarde.";
            } else if (statusCode == 403) {
                titulo = "Acceso Denegado (403)";
                mensaje = "No tienes permisos suficientes para ver este recurso.";
            }
        }

        model.addAttribute("titulo", titulo);
        model.addAttribute("mensaje", mensaje);
        
        return "error"; // Retorna la vista error.html
    }
}