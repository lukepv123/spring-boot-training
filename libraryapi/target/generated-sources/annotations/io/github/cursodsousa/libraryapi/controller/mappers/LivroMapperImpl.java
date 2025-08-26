package io.github.cursodsousa.libraryapi.controller.mappers;

import io.github.cursodsousa.libraryapi.dto.AutorDTO;
import io.github.cursodsousa.libraryapi.dto.CadastroLivroDTO;
import io.github.cursodsousa.libraryapi.dto.ResultadoPesquisaLivroDTO;
import io.github.cursodsousa.libraryapi.model.GeneroLivro;
import io.github.cursodsousa.libraryapi.model.Livro;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.hibernate.validator.constraints.UUID;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-18T18:58:38-0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class LivroMapperImpl extends LivroMapper {

    @Override
    public Livro toEntity(CadastroLivroDTO cadastroLivroDTO) {
        if ( cadastroLivroDTO == null ) {
            return null;
        }

        Livro livro = new Livro();

        livro.setIsbn( cadastroLivroDTO.isbn() );
        livro.setTitulo( cadastroLivroDTO.titulo() );
        livro.setGenero( cadastroLivroDTO.genero() );
        livro.setPreco( cadastroLivroDTO.preco() );

        livro.setAutor( autorRepository.findById(cadastroLivroDTO.idAutor()).orElse(null) );

        return livro;
    }

    @Override
    public ResultadoPesquisaLivroDTO toDTO(Livro livro) {
        if ( livro == null ) {
            return null;
        }

        String isbn = null;
        String titulo = null;
        GeneroLivro genero = null;
        BigDecimal preco = null;

        isbn = livro.getIsbn();
        titulo = livro.getTitulo();
        genero = livro.getGenero();
        preco = livro.getPreco();

        UUID idAutor = null;
        LocalDate dataPublicacao = null;
        AutorDTO autorDTO = null;

        ResultadoPesquisaLivroDTO resultadoPesquisaLivroDTO = new ResultadoPesquisaLivroDTO( idAutor, isbn, titulo, dataPublicacao, genero, preco, autorDTO );

        return resultadoPesquisaLivroDTO;
    }
}
