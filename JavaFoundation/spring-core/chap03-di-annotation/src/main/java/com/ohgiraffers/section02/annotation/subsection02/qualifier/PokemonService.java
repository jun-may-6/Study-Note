package com.ohgiraffers.section02.annotation.subsection02.qualifier;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceQealifier")
public class PokemonService {
    /* 필드 주입 방식 */
//    @Autowired
//    @Qualifier("pikachu")

    /* 생성자 주입 방식 */
    @Autowired
    public PokemonService(@Qualifier("squitle") Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    private Pokemon pokemon;
    public void pokemonAttack(){
        pokemon.attack();
    }

}
