package com.canbaylan.springboot;

import com.canbaylan.springboot.entity.Wikimedia;
import com.canbaylan.springboot.repository.WikimediaRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafaDatabaseConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafaDatabaseConsumer.class);
    private WikimediaRepository dataRepository;

    public KafaDatabaseConsumer(WikimediaRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @KafkaListener(topics= "wikimedia_recentchange",
                    groupId="myGroup")
    public void consume(String eventMessage){
        LOGGER.info(String.format("Message received -> %s",eventMessage));
        Wikimedia wikimedia = new Wikimedia();
        wikimedia.setWikiEvent(eventMessage);
        dataRepository.save(wikimedia);




    }
}
