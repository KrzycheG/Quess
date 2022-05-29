package com.example.demo.Session;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SessionServiceTest {

    @Mock
    private SessionRepository sessionRepository;

    @InjectMocks
    private SessionService underTest;


    @Test
    void start() {

        underTest.start();

        ArgumentCaptor<Session> sessionArgumentCaptor = ArgumentCaptor.forClass(Session.class);

        verify(sessionRepository).insert(sessionArgumentCaptor.capture());

    }

    @Test
    void quess() {

        Session sesh = new Session("asd");

        when(sessionRepository.findById("asd")).thenReturn(Optional.of(sesh));
        underTest.quess("asd",15);

        ArgumentCaptor<Session> sessionArgumentCaptor = ArgumentCaptor.forClass(Session.class);
        verify(sessionRepository).save(sessionArgumentCaptor.capture());


    }

    @Test
    void highscores() {

        List<Session> top15 = new ArrayList<>();
        top15.add(new Session("top1", 1));
        top15.add(new Session("top2", 2));
        top15.add(new Session("top3", 3));
        top15.add(new Session("top4", 4));
        top15.add(new Session("top5", 5));
        top15.add(new Session("top6", 6));
        top15.add(new Session("top7", 7));
        top15.add(new Session("top8", 8));
        top15.add(new Session("top9", 9));
        top15.add(new Session("top10", 10));
        top15.add(new Session("top11", 11));
        top15.add(new Session("top12", 12));
        top15.add(new Session("top13", 13));
        top15.add(new Session("top14", 14));

        when(sessionRepository.findAll(Sort.by(Sort.Direction.DESC, "numberOfTries"))).thenReturn(top15);

        List<Session> asd = underTest.highscores();

        Assertions.assertTrue(asd.size() <= 10);
        Assertions.assertTrue(asd.get(0).getNumberOfTries() <= asd.get(asd.size() - 1).getNumberOfTries());

    }
}