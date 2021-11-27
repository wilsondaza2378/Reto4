package co.usa.ciclo3reto4.ciclo3.service;

import co.usa.ciclo3reto4.ciclo3.model.Score;
import co.usa.ciclo3reto4.ciclo3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll() {
        return scoreRepository.getAll(); }

    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }

    public Score save(Score score){
        if(score.getIdScore()==null){
            return scoreRepository.save(score);
        }else {
            Optional<Score> scoreAux=scoreRepository.getScore(score.getIdScore());
            if(scoreAux.isEmpty()){
                return scoreRepository.save(score);
            }else{
                return score;
            }
        }
    }
    
        public Score update(Score score){
        if(score.getIdScore()!=null){
            Optional<Score> scoreAux=scoreRepository.getScore(score.getIdScore());
            if(!scoreAux.isEmpty()){
                if(score.getMessageScore()!=null){
                    scoreAux.get().setMessageScore(score.getMessageScore());
                }
                if(score.getScore()!=null){
                    scoreAux.get().setScore(score.getScore());
                }

                return scoreRepository.save(scoreAux.get());
            }
        }
        return score;
    }
}
