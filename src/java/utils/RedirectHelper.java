/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import model.User;

/**
 *
 * @author emsnguyen
 */
public class RedirectHelper {
    public static String redirectAfterAuthentication(User u, String urlAdmin, String urlMember) {
        if (u.getRollID() == 1) {
            return urlAdmin;
        } else {
            return urlMember;
        }
    }
}
