package co.usa.ciclo3reto4.ciclo3.service;

import co.usa.ciclo3reto4.ciclo3.model.Category;
import co.usa.ciclo3reto4.ciclo3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category category){
        if(category.getId()==null){
            return categoryRepository.save(category);
        }else {
            Optional<Category> categoriaAux=categoryRepository.getCategory(category.getId());
            if(categoriaAux.isEmpty()){
                return categoryRepository.save(category);
            }else{
                return category;
            }
        }
    }
    
        public Category update(Category categoria){
        if(categoria.getId()!=null){
            Optional<Category> catg=categoryRepository.getCategory(categoria.getId());
            if(!catg.isEmpty()){
                if(categoria.getName()!=null){
                    catg.get().setName(categoria.getName());
                }
                if(categoria.getDescription()!=null) {
                    catg.get().setDescription(categoria.getDescription());
                }
                return categoryRepository.save(catg.get());
            }
        }
        return categoria;
    }

    public boolean deleteCategoria(int id){
        Optional<Category> catAux=getCategory(id);
        if(!catAux.isEmpty()){
            categoryRepository.delete(catAux.get());
            return true;
        }
        return false;
    }
    
 }
