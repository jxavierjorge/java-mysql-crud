/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;

/**
 *
 * @author jxavi
 */
public interface IDAO<T> {

    void adicionar(T entidade);

    void atualizar(T entidade);

    void remover(int id);

    T buscarPorId(int id);

    ArrayList<T> buscarTodos();
}
