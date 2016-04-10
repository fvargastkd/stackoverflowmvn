package com.xsalefter.stackoverflowmvn;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xsalefter.stackoverflowmvn.entity.Utilisateur;
import com.xsalefter.stackoverflowmvn.repository.UtilisateurRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Config.class)
public class UtilisateurRepositoryTest {

    private static final Logger LOG = LoggerFactory.getLogger(UtilisateurRepositoryTest.class);

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Test
    public void testFindAll() {
        final List<Utilisateur> result = this.utilisateurRepository.findAll();
        result.stream().forEach( u -> LOG.info("Data: {}", u) );

        Assert.assertFalse(result.isEmpty());
    }
}
