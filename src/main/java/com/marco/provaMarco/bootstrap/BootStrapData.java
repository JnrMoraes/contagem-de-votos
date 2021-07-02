package com.marco.provaMarco.bootstrap;

import com.marco.provaMarco.domain.Candidato;
import com.marco.provaMarco.domain.Voto;
import com.marco.provaMarco.domain.Secao;
import com.marco.provaMarco.domain.Urna;
import com.marco.provaMarco.domain.Zona;
import com.marco.provaMarco.repository.ICandidatoRepository;
import com.marco.provaMarco.repository.ISecaoRepository;
import com.marco.provaMarco.repository.IUrnaRepository;
import com.marco.provaMarco.repository.IZonaRepositoty;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {

    private final ICandidatoRepository candidatoRepository;
    private final ISecaoRepository secaoRepository;
    private final IUrnaRepository urnaRepository;
    private final IZonaRepositoty zonaRepositoty;


    public BootStrapData(ICandidatoRepository candidatoRepository,
                         ISecaoRepository secaoRepository,
                         IUrnaRepository urnaRepository,
                         IZonaRepositoty zonaRepositoty) {
        this.candidatoRepository = candidatoRepository;
        this.secaoRepository = secaoRepository;
        this.urnaRepository = urnaRepository;
        this.zonaRepositoty = zonaRepositoty;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-: Stared in Bootstrap :-");

        // instancia novas urnas para zona leste
        Urna urnaLeste1 = new Urna("Urna Leste 1");
        Urna urnaLeste2 = new Urna("Urna Leste 2");
        Urna urnaLeste3 = new Urna("Urna Leste 3");
        Urna urnaLeste4 = new Urna("Urna Leste 4");

        //adiciona as urnas em uma lista de zona - Leste1
        List<Urna> lest1List = new ArrayList<>();
        lest1List.add(urnaLeste1);
        lest1List.add(urnaLeste2);

        //adiciona as urnas em uma lista de zona - Leste2
        List<Urna> lest2List = new ArrayList<>();
        lest1List.add(urnaLeste3);
        lest1List.add(urnaLeste4);

        // instancia novas urnas para zona leste
        Urna urnaNorte1 = new Urna("Urna Norte 1");
        Urna urnaNorte2 = new Urna("Urna Norte 2");
        Urna urnaNorte3 = new Urna("Urna Norte 3");
        Urna urnaNorte4 = new Urna("Urna Norte 4");

        //adiciona as urnas em uma lista de zona - Norte1
        List<Urna> norte1List = new ArrayList<>();
        lest1List.add(urnaNorte1);
        lest1List.add(urnaNorte2);
        //adiciona as urnas em uma lista de zona - Norte2
        List<Urna> norte2List = new ArrayList<>();
        lest1List.add(urnaNorte3);
        lest1List.add(urnaNorte4);

        //adiciona as urnas em uma lista de secao - Leste
        List<Urna> totalUrnasLeste = new ArrayList<>();
        totalUrnasLeste.add(urnaLeste1);
        totalUrnasLeste.add(urnaLeste2);
        totalUrnasLeste.add(urnaLeste3);
        totalUrnasLeste.add(urnaLeste4);

        //adiciona as urnas em uma lista de secao - Norte
        List<Urna> totalUrnasNorte = new ArrayList<>();
        totalUrnasNorte.add(urnaNorte1);
        totalUrnasNorte.add(urnaNorte2);
        totalUrnasNorte.add(urnaNorte3);
        totalUrnasNorte.add(urnaNorte4);

        //adiciona as urnas em uma lista total
        List<Urna> totalUrnas = new ArrayList<>();
        totalUrnas.add(urnaLeste1);
        totalUrnas.add(urnaLeste2);
        totalUrnas.add(urnaLeste3);
        totalUrnas.add(urnaLeste4);
        totalUrnas.add(urnaNorte1);
        totalUrnas.add(urnaNorte2);
        totalUrnas.add(urnaNorte3);
        totalUrnas.add(urnaNorte4);

        //salva as urnas em no Banco
        urnaRepository.save(urnaLeste1);
        urnaRepository.save(urnaLeste2);
        urnaRepository.save(urnaLeste3);
        urnaRepository.save(urnaLeste4);
        urnaRepository.save(urnaNorte1);
        urnaRepository.save(urnaNorte2);
        urnaRepository.save(urnaNorte3);
        urnaRepository.save(urnaNorte4);

        //instancia seções Leste
        Secao secaoLeste1 = new Secao("Secao Leste 1", lest1List);
        Secao secaoLeste2 = new Secao("Secao Leste 2", lest2List);

        //adiciona as secao em uma lista de secao - Leste
        List<Secao> secaoLestList = new ArrayList<>();
        secaoLestList.add(secaoLeste1);
        secaoLestList.add(secaoLeste2);

        //instancia seções Norte
        Secao secaoNorte1 = new Secao("Secao Norte 1", norte1List);
        Secao secaoNorte2 = new Secao("Secao Norte 2", norte2List);

        //adiciona as seção em uma lista de secao - Norte
        List<Secao> secaoNorteList = new ArrayList<>();
        secaoLestList.add(secaoNorte1);
        secaoLestList.add(secaoNorte2);

        //adiciona as seção em uma lista de secao - Norte
        List<Secao> totalSecoes = new ArrayList<>();
        totalSecoes.add(secaoLeste1);
        totalSecoes.add(secaoLeste2);
        totalSecoes.add(secaoNorte1);
        totalSecoes.add(secaoNorte2);

        //salva as seções no Banco
        secaoRepository.save(secaoLeste1);
        secaoRepository.save(secaoLeste2);
        secaoRepository.save(secaoNorte1);
        secaoRepository.save(secaoLeste2);

        //Instancia Zonas
        Zona zonaLeste = new Zona("Zona Leste",secaoLestList, totalUrnasLeste);
        Zona zonaNorte = new Zona("Zona Norte", secaoNorteList, totalUrnasNorte);

        //Adiciona total zonas em lista
        List<Zona> totalZonas = new ArrayList<>();
        totalZonas.add(zonaLeste);
        totalZonas.add(zonaNorte);

        //Salav zonas no Banco
        zonaRepositoty.save(zonaLeste);
        zonaRepositoty.save(zonaNorte);

        //Instancia candidatos
        Candidato candidatoJose = new Candidato("Jose das Neves", totalSecoes,totalZonas, totalUrnas);
        candidatoJose.setQuantidadeVotos(11);
        Candidato candidatoManoel = new Candidato("Manoel dos Campos", totalSecoes,totalZonas, totalUrnas);
        candidatoManoel.setQuantidadeVotos(31);
        candidatoRepository.save(candidatoJose);
        candidatoRepository.save(candidatoManoel);

        //Adiciona total de candidatos na lista
        List<Candidato> canditatos = new ArrayList<>();
        canditatos.add(candidatoJose);
        canditatos.add(candidatoManoel);

        // faz o link entre urnas e candidatos
        urnaLeste1.setCandidatos(canditatos);
        urnaRepository.save(urnaLeste1);
        urnaLeste2.setCandidatos(canditatos);
        urnaRepository.save(urnaLeste2);
        urnaLeste3.setCandidatos(canditatos);
        urnaRepository.save(urnaLeste3);
        urnaLeste4.setCandidatos(canditatos);
        urnaRepository.save(urnaLeste4);
        urnaNorte1.setCandidatos(canditatos);
        urnaRepository.save(urnaNorte1);
        urnaNorte2.setCandidatos(canditatos);
        urnaRepository.save(urnaNorte2);
        urnaNorte3.setCandidatos(canditatos);
        urnaRepository.save(urnaNorte3);
        urnaNorte4.setCandidatos(canditatos);
        urnaRepository.save(urnaNorte4);

        //faz o lin entre zona e candidatos
        zonaLeste.setCandidatos(canditatos);
        zonaRepositoty.save(zonaLeste);
        zonaNorte.setCandidatos(canditatos);
        zonaRepositoty.save(zonaNorte);

        //faz o link entre seções e candidatos
        secaoLeste1.setCandidatos(canditatos);
        secaoRepository.save(secaoLeste1);
        secaoLeste2.setCandidatos(canditatos);
        secaoRepository.save(secaoLeste2);
        secaoNorte1.setCandidatos(canditatos);
        secaoRepository.save(secaoNorte1);
        secaoNorte2.setCandidatos(canditatos);
        secaoRepository.save(secaoNorte2);

        System.out.println( "Canditados: " + candidatoRepository.count());
        System.out.println( "Zonas: " + zonaRepositoty.count());
        System.out.println( "Seções: " + secaoRepository.count());
        System.out.println( "Urnas: " + urnaRepository.count());
        System.out.println("Votos por candidato Jose das Neves: " + candidatoRepository
                                                            .findByName("Jose das Neves").getQuantidadeVotos());
        System.out.println("Votos por candidato Manoel dos Campos: " + candidatoRepository
                                                            .findByName("Manoel dos Campos")
                                                            .getQuantidadeVotos());

        Voto voto = new Voto();

        System.out.println("Votos totais na Secao Leste 1 " +
                QuantidadeVotosPorSecao("Secao Leste 1"));

        System.out.println("Votos totais na Secao Leste 2 " +
                QuantidadeVotosPorSecao("Secao Leste 2"));

    }
    private Integer QuantidadeVotosPorSecao(String candidato) {

        List<Candidato> candidatosList = this.secaoRepository.findByName(candidato).getCandidatos();
        Integer candidatoVotos = candidatosList.stream()
                .map(Candidato::getQuantidadeVotos)
                .reduce(0, Integer::sum);
        return  candidatoVotos;
    }

    private void votar( Voto voto ){

    }

}
