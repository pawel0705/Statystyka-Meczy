
package pl.polsl.lab6.pawel.salicki.webServices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.polsl.lab6.pawel.salicki.webServices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _HeuristicMixedException_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "HeuristicMixedException");
    private final static QName _HeuristicRollbackException_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "HeuristicRollbackException");
    private final static QName _IOException_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "IOException");
    private final static QName _NotSupportedException_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "NotSupportedException");
    private final static QName _RollbackException_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "RollbackException");
    private final static QName _SystemException_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "SystemException");
    private final static QName _WrongInputException_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "WrongInputException");
    private final static QName _AddGuestPlayer_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "addGuestPlayer");
    private final static QName _AddGuestPlayerResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "addGuestPlayerResponse");
    private final static QName _AddHostPlayer_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "addHostPlayer");
    private final static QName _AddHostPlayerResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "addHostPlayerResponse");
    private final static QName _AddNewMatch_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "addNewMatch");
    private final static QName _AddNewMatchResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "addNewMatchResponse");
    private final static QName _AddNewMatchToJPA_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "addNewMatchToJPA");
    private final static QName _AddNewMatchToJPAResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "addNewMatchToJPAResponse");
    private final static QName _Arbiters_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "arbiters");
    private final static QName _ArbitersCreateQuery_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "arbitersCreateQuery");
    private final static QName _ArbitersCreateQueryResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "arbitersCreateQueryResponse");
    private final static QName _CreateDatabase_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "createDatabase");
    private final static QName _CreateDatabaseResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "createDatabaseResponse");
    private final static QName _CreateGuestSoccerTeam_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "createGuestSoccerTeam");
    private final static QName _CreateGuestSoccerTeamResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "createGuestSoccerTeamResponse");
    private final static QName _CreateHostSoccerTeam_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "createHostSoccerTeam");
    private final static QName _CreateHostSoccerTeamResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "createHostSoccerTeamResponse");
    private final static QName _DeleteAllMatches_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "deleteAllMatches");
    private final static QName _DeleteAllMatchesDatabase_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "deleteAllMatchesDatabase");
    private final static QName _DeleteAllMatchesDatabaseResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "deleteAllMatchesDatabaseResponse");
    private final static QName _DeleteAllMatchesResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "deleteAllMatchesResponse");
    private final static QName _DeleteMatchById_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "deleteMatchById");
    private final static QName _DeleteMatchByIdResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "deleteMatchByIdResponse");
    private final static QName _DeleteOneMatchDatabase_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "deleteOneMatchDatabase");
    private final static QName _DeleteOneMatchDatabaseResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "deleteOneMatchDatabaseResponse");
    private final static QName _GetArbiterName_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getArbiterName");
    private final static QName _GetArbiterNameResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getArbiterNameResponse");
    private final static QName _GetArbitratorAssistantName_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getArbitratorAssistantName");
    private final static QName _GetArbitratorAssistantNameResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getArbitratorAssistantNameResponse");
    private final static QName _GetArbitratorAssistantsSize_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getArbitratorAssistantsSize");
    private final static QName _GetArbitratorAssistantsSizeResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getArbitratorAssistantsSizeResponse");
    private final static QName _GetBasicMatchesInfo_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getBasicMatchesInfo");
    private final static QName _GetBasicMatchesInfoResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getBasicMatchesInfoResponse");
    private final static QName _GetGuestPlayerEntryTime_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getGuestPlayerEntryTime");
    private final static QName _GetGuestPlayerEntryTimeResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getGuestPlayerEntryTimeResponse");
    private final static QName _GetGuestPlayerFouls_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getGuestPlayerFouls");
    private final static QName _GetGuestPlayerFoulsResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getGuestPlayerFoulsResponse");
    private final static QName _GetGuestPlayerLeftTime_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getGuestPlayerLeftTime");
    private final static QName _GetGuestPlayerLeftTimeResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getGuestPlayerLeftTimeResponse");
    private final static QName _GetGuestPlayerName_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getGuestPlayerName");
    private final static QName _GetGuestPlayerNameResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getGuestPlayerNameResponse");
    private final static QName _GetGuestPlayerPlayedWholeTime_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getGuestPlayerPlayedWholeTime");
    private final static QName _GetGuestPlayerPlayedWholeTimeResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getGuestPlayerPlayedWholeTimeResponse");
    private final static QName _GetGuestPlayerRedCard_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getGuestPlayerRedCard");
    private final static QName _GetGuestPlayerRedCardResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getGuestPlayerRedCardResponse");
    private final static QName _GetGuestPlayerScoredGoals_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getGuestPlayerScoredGoals");
    private final static QName _GetGuestPlayerScoredGoalsResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getGuestPlayerScoredGoalsResponse");
    private final static QName _GetGuestPlayerYellowCards_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getGuestPlayerYellowCards");
    private final static QName _GetGuestPlayerYellowCardsResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getGuestPlayerYellowCardsResponse");
    private final static QName _GetGuestTeamCoachName_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getGuestTeamCoachName");
    private final static QName _GetGuestTeamCoachNameResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getGuestTeamCoachNameResponse");
    private final static QName _GetGuestTeamCountryName_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getGuestTeamCountryName");
    private final static QName _GetGuestTeamCountryNameResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getGuestTeamCountryNameResponse");
    private final static QName _GetGuestTeamName_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getGuestTeamName");
    private final static QName _GetGuestTeamNameResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getGuestTeamNameResponse");
    private final static QName _GetGuestTeamPlayersSize_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getGuestTeamPlayersSize");
    private final static QName _GetGuestTeamPlayersSizeResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getGuestTeamPlayersSizeResponse");
    private final static QName _GetHostPlayerEntryTime_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getHostPlayerEntryTime");
    private final static QName _GetHostPlayerEntryTimeResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getHostPlayerEntryTimeResponse");
    private final static QName _GetHostPlayerFouls_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getHostPlayerFouls");
    private final static QName _GetHostPlayerFoulsResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getHostPlayerFoulsResponse");
    private final static QName _GetHostPlayerLeftTime_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getHostPlayerLeftTime");
    private final static QName _GetHostPlayerLeftTimeResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getHostPlayerLeftTimeResponse");
    private final static QName _GetHostPlayerName_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getHostPlayerName");
    private final static QName _GetHostPlayerNameResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getHostPlayerNameResponse");
    private final static QName _GetHostPlayerPlayedWholeTime_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getHostPlayerPlayedWholeTime");
    private final static QName _GetHostPlayerPlayedWholeTimeResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getHostPlayerPlayedWholeTimeResponse");
    private final static QName _GetHostPlayerRedCard_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getHostPlayerRedCard");
    private final static QName _GetHostPlayerRedCardResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getHostPlayerRedCardResponse");
    private final static QName _GetHostPlayerScoredGoals_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getHostPlayerScoredGoals");
    private final static QName _GetHostPlayerScoredGoalsResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getHostPlayerScoredGoalsResponse");
    private final static QName _GetHostPlayerYellowCards_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getHostPlayerYellowCards");
    private final static QName _GetHostPlayerYellowCardsResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getHostPlayerYellowCardsResponse");
    private final static QName _GetHostTeamCoachName_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getHostTeamCoachName");
    private final static QName _GetHostTeamCoachNameResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getHostTeamCoachNameResponse");
    private final static QName _GetHostTeamCountryName_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getHostTeamCountryName");
    private final static QName _GetHostTeamCountryNameResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getHostTeamCountryNameResponse");
    private final static QName _GetHostTeamName_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getHostTeamName");
    private final static QName _GetHostTeamNameResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getHostTeamNameResponse");
    private final static QName _GetHostTeamPlayersSize_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getHostTeamPlayersSize");
    private final static QName _GetHostTeamPlayersSizeResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getHostTeamPlayersSizeResponse");
    private final static QName _GetMatchId_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getMatchId");
    private final static QName _GetMatchIdResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getMatchIdResponse");
    private final static QName _GetMatchTime_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getMatchTime");
    private final static QName _GetMatchTimeResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getMatchTimeResponse");
    private final static QName _GetNumberOfMatches_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getNumberOfMatches");
    private final static QName _GetNumberOfMatchesResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "getNumberOfMatchesResponse");
    private final static QName _HasMatchInData_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "hasMatchInData");
    private final static QName _HasMatchInDataResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "hasMatchInDataResponse");
    private final static QName _Matches_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "matches");
    private final static QName _MatchesCreateQuery_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "matchesCreateQuery");
    private final static QName _MatchesCreateQueryResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "matchesCreateQueryResponse");
    private final static QName _Persist_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "persist");
    private final static QName _PersistResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "persistResponse");
    private final static QName _PlayerCreateQuery_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "playerCreateQuery");
    private final static QName _PlayerCreateQueryResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "playerCreateQueryResponse");
    private final static QName _Players_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "players");
    private final static QName _ReadDatabaseFromFile_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "readDatabaseFromFile");
    private final static QName _ReadDatabaseFromFileResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "readDatabaseFromFileResponse");
    private final static QName _ReadMatchFromFileDatabase_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "readMatchFromFileDatabase");
    private final static QName _ReadMatchFromFileDatabaseResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "readMatchFromFileDatabaseResponse");
    private final static QName _SaveDatabaseToFile_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "saveDatabaseToFile");
    private final static QName _SaveDatabaseToFileResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "saveDatabaseToFileResponse");
    private final static QName _ShowDatabaseArbitersList_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "showDatabaseArbitersList");
    private final static QName _ShowDatabaseArbitersListResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "showDatabaseArbitersListResponse");
    private final static QName _ShowDatabaseMatchesList_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "showDatabaseMatchesList");
    private final static QName _ShowDatabaseMatchesListResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "showDatabaseMatchesListResponse");
    private final static QName _ShowDatabasePlayersList_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "showDatabasePlayersList");
    private final static QName _ShowDatabasePlayersListResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "showDatabasePlayersListResponse");
    private final static QName _ShowDatabaseTeamList_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "showDatabaseTeamList");
    private final static QName _ShowDatabaseTeamListResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "showDatabaseTeamListResponse");
    private final static QName _Team_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "team");
    private final static QName _TeamCreateQuery_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "teamCreateQuery");
    private final static QName _TeamCreateQueryResponse_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "teamCreateQueryResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.polsl.lab6.pawel.salicki.webServices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HeuristicMixedException }
     * 
     */
    public HeuristicMixedException createHeuristicMixedException() {
        return new HeuristicMixedException();
    }

    /**
     * Create an instance of {@link HeuristicRollbackException }
     * 
     */
    public HeuristicRollbackException createHeuristicRollbackException() {
        return new HeuristicRollbackException();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link NotSupportedException }
     * 
     */
    public NotSupportedException createNotSupportedException() {
        return new NotSupportedException();
    }

    /**
     * Create an instance of {@link RollbackException }
     * 
     */
    public RollbackException createRollbackException() {
        return new RollbackException();
    }

    /**
     * Create an instance of {@link SystemException }
     * 
     */
    public SystemException createSystemException() {
        return new SystemException();
    }

    /**
     * Create an instance of {@link WrongInputException }
     * 
     */
    public WrongInputException createWrongInputException() {
        return new WrongInputException();
    }

    /**
     * Create an instance of {@link AddGuestPlayer }
     * 
     */
    public AddGuestPlayer createAddGuestPlayer() {
        return new AddGuestPlayer();
    }

    /**
     * Create an instance of {@link AddGuestPlayerResponse }
     * 
     */
    public AddGuestPlayerResponse createAddGuestPlayerResponse() {
        return new AddGuestPlayerResponse();
    }

    /**
     * Create an instance of {@link AddHostPlayer }
     * 
     */
    public AddHostPlayer createAddHostPlayer() {
        return new AddHostPlayer();
    }

    /**
     * Create an instance of {@link AddHostPlayerResponse }
     * 
     */
    public AddHostPlayerResponse createAddHostPlayerResponse() {
        return new AddHostPlayerResponse();
    }

    /**
     * Create an instance of {@link AddNewMatch }
     * 
     */
    public AddNewMatch createAddNewMatch() {
        return new AddNewMatch();
    }

    /**
     * Create an instance of {@link AddNewMatchResponse }
     * 
     */
    public AddNewMatchResponse createAddNewMatchResponse() {
        return new AddNewMatchResponse();
    }

    /**
     * Create an instance of {@link AddNewMatchToJPA }
     * 
     */
    public AddNewMatchToJPA createAddNewMatchToJPA() {
        return new AddNewMatchToJPA();
    }

    /**
     * Create an instance of {@link AddNewMatchToJPAResponse }
     * 
     */
    public AddNewMatchToJPAResponse createAddNewMatchToJPAResponse() {
        return new AddNewMatchToJPAResponse();
    }

    /**
     * Create an instance of {@link Arbiters }
     * 
     */
    public Arbiters createArbiters() {
        return new Arbiters();
    }

    /**
     * Create an instance of {@link ArbitersCreateQuery }
     * 
     */
    public ArbitersCreateQuery createArbitersCreateQuery() {
        return new ArbitersCreateQuery();
    }

    /**
     * Create an instance of {@link ArbitersCreateQueryResponse }
     * 
     */
    public ArbitersCreateQueryResponse createArbitersCreateQueryResponse() {
        return new ArbitersCreateQueryResponse();
    }

    /**
     * Create an instance of {@link CreateDatabase }
     * 
     */
    public CreateDatabase createCreateDatabase() {
        return new CreateDatabase();
    }

    /**
     * Create an instance of {@link CreateDatabaseResponse }
     * 
     */
    public CreateDatabaseResponse createCreateDatabaseResponse() {
        return new CreateDatabaseResponse();
    }

    /**
     * Create an instance of {@link CreateGuestSoccerTeam }
     * 
     */
    public CreateGuestSoccerTeam createCreateGuestSoccerTeam() {
        return new CreateGuestSoccerTeam();
    }

    /**
     * Create an instance of {@link CreateGuestSoccerTeamResponse }
     * 
     */
    public CreateGuestSoccerTeamResponse createCreateGuestSoccerTeamResponse() {
        return new CreateGuestSoccerTeamResponse();
    }

    /**
     * Create an instance of {@link CreateHostSoccerTeam }
     * 
     */
    public CreateHostSoccerTeam createCreateHostSoccerTeam() {
        return new CreateHostSoccerTeam();
    }

    /**
     * Create an instance of {@link CreateHostSoccerTeamResponse }
     * 
     */
    public CreateHostSoccerTeamResponse createCreateHostSoccerTeamResponse() {
        return new CreateHostSoccerTeamResponse();
    }

    /**
     * Create an instance of {@link DeleteAllMatches }
     * 
     */
    public DeleteAllMatches createDeleteAllMatches() {
        return new DeleteAllMatches();
    }

    /**
     * Create an instance of {@link DeleteAllMatchesDatabase }
     * 
     */
    public DeleteAllMatchesDatabase createDeleteAllMatchesDatabase() {
        return new DeleteAllMatchesDatabase();
    }

    /**
     * Create an instance of {@link DeleteAllMatchesDatabaseResponse }
     * 
     */
    public DeleteAllMatchesDatabaseResponse createDeleteAllMatchesDatabaseResponse() {
        return new DeleteAllMatchesDatabaseResponse();
    }

    /**
     * Create an instance of {@link DeleteAllMatchesResponse }
     * 
     */
    public DeleteAllMatchesResponse createDeleteAllMatchesResponse() {
        return new DeleteAllMatchesResponse();
    }

    /**
     * Create an instance of {@link DeleteMatchById }
     * 
     */
    public DeleteMatchById createDeleteMatchById() {
        return new DeleteMatchById();
    }

    /**
     * Create an instance of {@link DeleteMatchByIdResponse }
     * 
     */
    public DeleteMatchByIdResponse createDeleteMatchByIdResponse() {
        return new DeleteMatchByIdResponse();
    }

    /**
     * Create an instance of {@link DeleteOneMatchDatabase }
     * 
     */
    public DeleteOneMatchDatabase createDeleteOneMatchDatabase() {
        return new DeleteOneMatchDatabase();
    }

    /**
     * Create an instance of {@link DeleteOneMatchDatabaseResponse }
     * 
     */
    public DeleteOneMatchDatabaseResponse createDeleteOneMatchDatabaseResponse() {
        return new DeleteOneMatchDatabaseResponse();
    }

    /**
     * Create an instance of {@link GetArbiterName }
     * 
     */
    public GetArbiterName createGetArbiterName() {
        return new GetArbiterName();
    }

    /**
     * Create an instance of {@link GetArbiterNameResponse }
     * 
     */
    public GetArbiterNameResponse createGetArbiterNameResponse() {
        return new GetArbiterNameResponse();
    }

    /**
     * Create an instance of {@link GetArbitratorAssistantName }
     * 
     */
    public GetArbitratorAssistantName createGetArbitratorAssistantName() {
        return new GetArbitratorAssistantName();
    }

    /**
     * Create an instance of {@link GetArbitratorAssistantNameResponse }
     * 
     */
    public GetArbitratorAssistantNameResponse createGetArbitratorAssistantNameResponse() {
        return new GetArbitratorAssistantNameResponse();
    }

    /**
     * Create an instance of {@link GetArbitratorAssistantsSize }
     * 
     */
    public GetArbitratorAssistantsSize createGetArbitratorAssistantsSize() {
        return new GetArbitratorAssistantsSize();
    }

    /**
     * Create an instance of {@link GetArbitratorAssistantsSizeResponse }
     * 
     */
    public GetArbitratorAssistantsSizeResponse createGetArbitratorAssistantsSizeResponse() {
        return new GetArbitratorAssistantsSizeResponse();
    }

    /**
     * Create an instance of {@link GetBasicMatchesInfo }
     * 
     */
    public GetBasicMatchesInfo createGetBasicMatchesInfo() {
        return new GetBasicMatchesInfo();
    }

    /**
     * Create an instance of {@link GetBasicMatchesInfoResponse }
     * 
     */
    public GetBasicMatchesInfoResponse createGetBasicMatchesInfoResponse() {
        return new GetBasicMatchesInfoResponse();
    }

    /**
     * Create an instance of {@link GetGuestPlayerEntryTime }
     * 
     */
    public GetGuestPlayerEntryTime createGetGuestPlayerEntryTime() {
        return new GetGuestPlayerEntryTime();
    }

    /**
     * Create an instance of {@link GetGuestPlayerEntryTimeResponse }
     * 
     */
    public GetGuestPlayerEntryTimeResponse createGetGuestPlayerEntryTimeResponse() {
        return new GetGuestPlayerEntryTimeResponse();
    }

    /**
     * Create an instance of {@link GetGuestPlayerFouls }
     * 
     */
    public GetGuestPlayerFouls createGetGuestPlayerFouls() {
        return new GetGuestPlayerFouls();
    }

    /**
     * Create an instance of {@link GetGuestPlayerFoulsResponse }
     * 
     */
    public GetGuestPlayerFoulsResponse createGetGuestPlayerFoulsResponse() {
        return new GetGuestPlayerFoulsResponse();
    }

    /**
     * Create an instance of {@link GetGuestPlayerLeftTime }
     * 
     */
    public GetGuestPlayerLeftTime createGetGuestPlayerLeftTime() {
        return new GetGuestPlayerLeftTime();
    }

    /**
     * Create an instance of {@link GetGuestPlayerLeftTimeResponse }
     * 
     */
    public GetGuestPlayerLeftTimeResponse createGetGuestPlayerLeftTimeResponse() {
        return new GetGuestPlayerLeftTimeResponse();
    }

    /**
     * Create an instance of {@link GetGuestPlayerName }
     * 
     */
    public GetGuestPlayerName createGetGuestPlayerName() {
        return new GetGuestPlayerName();
    }

    /**
     * Create an instance of {@link GetGuestPlayerNameResponse }
     * 
     */
    public GetGuestPlayerNameResponse createGetGuestPlayerNameResponse() {
        return new GetGuestPlayerNameResponse();
    }

    /**
     * Create an instance of {@link GetGuestPlayerPlayedWholeTime }
     * 
     */
    public GetGuestPlayerPlayedWholeTime createGetGuestPlayerPlayedWholeTime() {
        return new GetGuestPlayerPlayedWholeTime();
    }

    /**
     * Create an instance of {@link GetGuestPlayerPlayedWholeTimeResponse }
     * 
     */
    public GetGuestPlayerPlayedWholeTimeResponse createGetGuestPlayerPlayedWholeTimeResponse() {
        return new GetGuestPlayerPlayedWholeTimeResponse();
    }

    /**
     * Create an instance of {@link GetGuestPlayerRedCard }
     * 
     */
    public GetGuestPlayerRedCard createGetGuestPlayerRedCard() {
        return new GetGuestPlayerRedCard();
    }

    /**
     * Create an instance of {@link GetGuestPlayerRedCardResponse }
     * 
     */
    public GetGuestPlayerRedCardResponse createGetGuestPlayerRedCardResponse() {
        return new GetGuestPlayerRedCardResponse();
    }

    /**
     * Create an instance of {@link GetGuestPlayerScoredGoals }
     * 
     */
    public GetGuestPlayerScoredGoals createGetGuestPlayerScoredGoals() {
        return new GetGuestPlayerScoredGoals();
    }

    /**
     * Create an instance of {@link GetGuestPlayerScoredGoalsResponse }
     * 
     */
    public GetGuestPlayerScoredGoalsResponse createGetGuestPlayerScoredGoalsResponse() {
        return new GetGuestPlayerScoredGoalsResponse();
    }

    /**
     * Create an instance of {@link GetGuestPlayerYellowCards }
     * 
     */
    public GetGuestPlayerYellowCards createGetGuestPlayerYellowCards() {
        return new GetGuestPlayerYellowCards();
    }

    /**
     * Create an instance of {@link GetGuestPlayerYellowCardsResponse }
     * 
     */
    public GetGuestPlayerYellowCardsResponse createGetGuestPlayerYellowCardsResponse() {
        return new GetGuestPlayerYellowCardsResponse();
    }

    /**
     * Create an instance of {@link GetGuestTeamCoachName }
     * 
     */
    public GetGuestTeamCoachName createGetGuestTeamCoachName() {
        return new GetGuestTeamCoachName();
    }

    /**
     * Create an instance of {@link GetGuestTeamCoachNameResponse }
     * 
     */
    public GetGuestTeamCoachNameResponse createGetGuestTeamCoachNameResponse() {
        return new GetGuestTeamCoachNameResponse();
    }

    /**
     * Create an instance of {@link GetGuestTeamCountryName }
     * 
     */
    public GetGuestTeamCountryName createGetGuestTeamCountryName() {
        return new GetGuestTeamCountryName();
    }

    /**
     * Create an instance of {@link GetGuestTeamCountryNameResponse }
     * 
     */
    public GetGuestTeamCountryNameResponse createGetGuestTeamCountryNameResponse() {
        return new GetGuestTeamCountryNameResponse();
    }

    /**
     * Create an instance of {@link GetGuestTeamName }
     * 
     */
    public GetGuestTeamName createGetGuestTeamName() {
        return new GetGuestTeamName();
    }

    /**
     * Create an instance of {@link GetGuestTeamNameResponse }
     * 
     */
    public GetGuestTeamNameResponse createGetGuestTeamNameResponse() {
        return new GetGuestTeamNameResponse();
    }

    /**
     * Create an instance of {@link GetGuestTeamPlayersSize }
     * 
     */
    public GetGuestTeamPlayersSize createGetGuestTeamPlayersSize() {
        return new GetGuestTeamPlayersSize();
    }

    /**
     * Create an instance of {@link GetGuestTeamPlayersSizeResponse }
     * 
     */
    public GetGuestTeamPlayersSizeResponse createGetGuestTeamPlayersSizeResponse() {
        return new GetGuestTeamPlayersSizeResponse();
    }

    /**
     * Create an instance of {@link GetHostPlayerEntryTime }
     * 
     */
    public GetHostPlayerEntryTime createGetHostPlayerEntryTime() {
        return new GetHostPlayerEntryTime();
    }

    /**
     * Create an instance of {@link GetHostPlayerEntryTimeResponse }
     * 
     */
    public GetHostPlayerEntryTimeResponse createGetHostPlayerEntryTimeResponse() {
        return new GetHostPlayerEntryTimeResponse();
    }

    /**
     * Create an instance of {@link GetHostPlayerFouls }
     * 
     */
    public GetHostPlayerFouls createGetHostPlayerFouls() {
        return new GetHostPlayerFouls();
    }

    /**
     * Create an instance of {@link GetHostPlayerFoulsResponse }
     * 
     */
    public GetHostPlayerFoulsResponse createGetHostPlayerFoulsResponse() {
        return new GetHostPlayerFoulsResponse();
    }

    /**
     * Create an instance of {@link GetHostPlayerLeftTime }
     * 
     */
    public GetHostPlayerLeftTime createGetHostPlayerLeftTime() {
        return new GetHostPlayerLeftTime();
    }

    /**
     * Create an instance of {@link GetHostPlayerLeftTimeResponse }
     * 
     */
    public GetHostPlayerLeftTimeResponse createGetHostPlayerLeftTimeResponse() {
        return new GetHostPlayerLeftTimeResponse();
    }

    /**
     * Create an instance of {@link GetHostPlayerName }
     * 
     */
    public GetHostPlayerName createGetHostPlayerName() {
        return new GetHostPlayerName();
    }

    /**
     * Create an instance of {@link GetHostPlayerNameResponse }
     * 
     */
    public GetHostPlayerNameResponse createGetHostPlayerNameResponse() {
        return new GetHostPlayerNameResponse();
    }

    /**
     * Create an instance of {@link GetHostPlayerPlayedWholeTime }
     * 
     */
    public GetHostPlayerPlayedWholeTime createGetHostPlayerPlayedWholeTime() {
        return new GetHostPlayerPlayedWholeTime();
    }

    /**
     * Create an instance of {@link GetHostPlayerPlayedWholeTimeResponse }
     * 
     */
    public GetHostPlayerPlayedWholeTimeResponse createGetHostPlayerPlayedWholeTimeResponse() {
        return new GetHostPlayerPlayedWholeTimeResponse();
    }

    /**
     * Create an instance of {@link GetHostPlayerRedCard }
     * 
     */
    public GetHostPlayerRedCard createGetHostPlayerRedCard() {
        return new GetHostPlayerRedCard();
    }

    /**
     * Create an instance of {@link GetHostPlayerRedCardResponse }
     * 
     */
    public GetHostPlayerRedCardResponse createGetHostPlayerRedCardResponse() {
        return new GetHostPlayerRedCardResponse();
    }

    /**
     * Create an instance of {@link GetHostPlayerScoredGoals }
     * 
     */
    public GetHostPlayerScoredGoals createGetHostPlayerScoredGoals() {
        return new GetHostPlayerScoredGoals();
    }

    /**
     * Create an instance of {@link GetHostPlayerScoredGoalsResponse }
     * 
     */
    public GetHostPlayerScoredGoalsResponse createGetHostPlayerScoredGoalsResponse() {
        return new GetHostPlayerScoredGoalsResponse();
    }

    /**
     * Create an instance of {@link GetHostPlayerYellowCards }
     * 
     */
    public GetHostPlayerYellowCards createGetHostPlayerYellowCards() {
        return new GetHostPlayerYellowCards();
    }

    /**
     * Create an instance of {@link GetHostPlayerYellowCardsResponse }
     * 
     */
    public GetHostPlayerYellowCardsResponse createGetHostPlayerYellowCardsResponse() {
        return new GetHostPlayerYellowCardsResponse();
    }

    /**
     * Create an instance of {@link GetHostTeamCoachName }
     * 
     */
    public GetHostTeamCoachName createGetHostTeamCoachName() {
        return new GetHostTeamCoachName();
    }

    /**
     * Create an instance of {@link GetHostTeamCoachNameResponse }
     * 
     */
    public GetHostTeamCoachNameResponse createGetHostTeamCoachNameResponse() {
        return new GetHostTeamCoachNameResponse();
    }

    /**
     * Create an instance of {@link GetHostTeamCountryName }
     * 
     */
    public GetHostTeamCountryName createGetHostTeamCountryName() {
        return new GetHostTeamCountryName();
    }

    /**
     * Create an instance of {@link GetHostTeamCountryNameResponse }
     * 
     */
    public GetHostTeamCountryNameResponse createGetHostTeamCountryNameResponse() {
        return new GetHostTeamCountryNameResponse();
    }

    /**
     * Create an instance of {@link GetHostTeamName }
     * 
     */
    public GetHostTeamName createGetHostTeamName() {
        return new GetHostTeamName();
    }

    /**
     * Create an instance of {@link GetHostTeamNameResponse }
     * 
     */
    public GetHostTeamNameResponse createGetHostTeamNameResponse() {
        return new GetHostTeamNameResponse();
    }

    /**
     * Create an instance of {@link GetHostTeamPlayersSize }
     * 
     */
    public GetHostTeamPlayersSize createGetHostTeamPlayersSize() {
        return new GetHostTeamPlayersSize();
    }

    /**
     * Create an instance of {@link GetHostTeamPlayersSizeResponse }
     * 
     */
    public GetHostTeamPlayersSizeResponse createGetHostTeamPlayersSizeResponse() {
        return new GetHostTeamPlayersSizeResponse();
    }

    /**
     * Create an instance of {@link GetMatchId }
     * 
     */
    public GetMatchId createGetMatchId() {
        return new GetMatchId();
    }

    /**
     * Create an instance of {@link GetMatchIdResponse }
     * 
     */
    public GetMatchIdResponse createGetMatchIdResponse() {
        return new GetMatchIdResponse();
    }

    /**
     * Create an instance of {@link GetMatchTime }
     * 
     */
    public GetMatchTime createGetMatchTime() {
        return new GetMatchTime();
    }

    /**
     * Create an instance of {@link GetMatchTimeResponse }
     * 
     */
    public GetMatchTimeResponse createGetMatchTimeResponse() {
        return new GetMatchTimeResponse();
    }

    /**
     * Create an instance of {@link GetNumberOfMatches }
     * 
     */
    public GetNumberOfMatches createGetNumberOfMatches() {
        return new GetNumberOfMatches();
    }

    /**
     * Create an instance of {@link GetNumberOfMatchesResponse }
     * 
     */
    public GetNumberOfMatchesResponse createGetNumberOfMatchesResponse() {
        return new GetNumberOfMatchesResponse();
    }

    /**
     * Create an instance of {@link HasMatchInData }
     * 
     */
    public HasMatchInData createHasMatchInData() {
        return new HasMatchInData();
    }

    /**
     * Create an instance of {@link HasMatchInDataResponse }
     * 
     */
    public HasMatchInDataResponse createHasMatchInDataResponse() {
        return new HasMatchInDataResponse();
    }

    /**
     * Create an instance of {@link Matches }
     * 
     */
    public Matches createMatches() {
        return new Matches();
    }

    /**
     * Create an instance of {@link MatchesCreateQuery }
     * 
     */
    public MatchesCreateQuery createMatchesCreateQuery() {
        return new MatchesCreateQuery();
    }

    /**
     * Create an instance of {@link MatchesCreateQueryResponse }
     * 
     */
    public MatchesCreateQueryResponse createMatchesCreateQueryResponse() {
        return new MatchesCreateQueryResponse();
    }

    /**
     * Create an instance of {@link Persist }
     * 
     */
    public Persist createPersist() {
        return new Persist();
    }

    /**
     * Create an instance of {@link PersistResponse }
     * 
     */
    public PersistResponse createPersistResponse() {
        return new PersistResponse();
    }

    /**
     * Create an instance of {@link PlayerCreateQuery }
     * 
     */
    public PlayerCreateQuery createPlayerCreateQuery() {
        return new PlayerCreateQuery();
    }

    /**
     * Create an instance of {@link PlayerCreateQueryResponse }
     * 
     */
    public PlayerCreateQueryResponse createPlayerCreateQueryResponse() {
        return new PlayerCreateQueryResponse();
    }

    /**
     * Create an instance of {@link Players }
     * 
     */
    public Players createPlayers() {
        return new Players();
    }

    /**
     * Create an instance of {@link ReadDatabaseFromFile }
     * 
     */
    public ReadDatabaseFromFile createReadDatabaseFromFile() {
        return new ReadDatabaseFromFile();
    }

    /**
     * Create an instance of {@link ReadDatabaseFromFileResponse }
     * 
     */
    public ReadDatabaseFromFileResponse createReadDatabaseFromFileResponse() {
        return new ReadDatabaseFromFileResponse();
    }

    /**
     * Create an instance of {@link ReadMatchFromFileDatabase }
     * 
     */
    public ReadMatchFromFileDatabase createReadMatchFromFileDatabase() {
        return new ReadMatchFromFileDatabase();
    }

    /**
     * Create an instance of {@link ReadMatchFromFileDatabaseResponse }
     * 
     */
    public ReadMatchFromFileDatabaseResponse createReadMatchFromFileDatabaseResponse() {
        return new ReadMatchFromFileDatabaseResponse();
    }

    /**
     * Create an instance of {@link SaveDatabaseToFile }
     * 
     */
    public SaveDatabaseToFile createSaveDatabaseToFile() {
        return new SaveDatabaseToFile();
    }

    /**
     * Create an instance of {@link SaveDatabaseToFileResponse }
     * 
     */
    public SaveDatabaseToFileResponse createSaveDatabaseToFileResponse() {
        return new SaveDatabaseToFileResponse();
    }

    /**
     * Create an instance of {@link ShowDatabaseArbitersList }
     * 
     */
    public ShowDatabaseArbitersList createShowDatabaseArbitersList() {
        return new ShowDatabaseArbitersList();
    }

    /**
     * Create an instance of {@link ShowDatabaseArbitersListResponse }
     * 
     */
    public ShowDatabaseArbitersListResponse createShowDatabaseArbitersListResponse() {
        return new ShowDatabaseArbitersListResponse();
    }

    /**
     * Create an instance of {@link ShowDatabaseMatchesList }
     * 
     */
    public ShowDatabaseMatchesList createShowDatabaseMatchesList() {
        return new ShowDatabaseMatchesList();
    }

    /**
     * Create an instance of {@link ShowDatabaseMatchesListResponse }
     * 
     */
    public ShowDatabaseMatchesListResponse createShowDatabaseMatchesListResponse() {
        return new ShowDatabaseMatchesListResponse();
    }

    /**
     * Create an instance of {@link ShowDatabasePlayersList }
     * 
     */
    public ShowDatabasePlayersList createShowDatabasePlayersList() {
        return new ShowDatabasePlayersList();
    }

    /**
     * Create an instance of {@link ShowDatabasePlayersListResponse }
     * 
     */
    public ShowDatabasePlayersListResponse createShowDatabasePlayersListResponse() {
        return new ShowDatabasePlayersListResponse();
    }

    /**
     * Create an instance of {@link ShowDatabaseTeamList }
     * 
     */
    public ShowDatabaseTeamList createShowDatabaseTeamList() {
        return new ShowDatabaseTeamList();
    }

    /**
     * Create an instance of {@link ShowDatabaseTeamListResponse }
     * 
     */
    public ShowDatabaseTeamListResponse createShowDatabaseTeamListResponse() {
        return new ShowDatabaseTeamListResponse();
    }

    /**
     * Create an instance of {@link Team }
     * 
     */
    public Team createTeam() {
        return new Team();
    }

    /**
     * Create an instance of {@link TeamCreateQuery }
     * 
     */
    public TeamCreateQuery createTeamCreateQuery() {
        return new TeamCreateQuery();
    }

    /**
     * Create an instance of {@link TeamCreateQueryResponse }
     * 
     */
    public TeamCreateQueryResponse createTeamCreateQueryResponse() {
        return new TeamCreateQueryResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HeuristicMixedException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "HeuristicMixedException")
    public JAXBElement<HeuristicMixedException> createHeuristicMixedException(HeuristicMixedException value) {
        return new JAXBElement<HeuristicMixedException>(_HeuristicMixedException_QNAME, HeuristicMixedException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HeuristicRollbackException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "HeuristicRollbackException")
    public JAXBElement<HeuristicRollbackException> createHeuristicRollbackException(HeuristicRollbackException value) {
        return new JAXBElement<HeuristicRollbackException>(_HeuristicRollbackException_QNAME, HeuristicRollbackException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<IOException>(_IOException_QNAME, IOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotSupportedException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "NotSupportedException")
    public JAXBElement<NotSupportedException> createNotSupportedException(NotSupportedException value) {
        return new JAXBElement<NotSupportedException>(_NotSupportedException_QNAME, NotSupportedException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RollbackException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "RollbackException")
    public JAXBElement<RollbackException> createRollbackException(RollbackException value) {
        return new JAXBElement<RollbackException>(_RollbackException_QNAME, RollbackException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SystemException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "SystemException")
    public JAXBElement<SystemException> createSystemException(SystemException value) {
        return new JAXBElement<SystemException>(_SystemException_QNAME, SystemException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WrongInputException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "WrongInputException")
    public JAXBElement<WrongInputException> createWrongInputException(WrongInputException value) {
        return new JAXBElement<WrongInputException>(_WrongInputException_QNAME, WrongInputException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddGuestPlayer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "addGuestPlayer")
    public JAXBElement<AddGuestPlayer> createAddGuestPlayer(AddGuestPlayer value) {
        return new JAXBElement<AddGuestPlayer>(_AddGuestPlayer_QNAME, AddGuestPlayer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddGuestPlayerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "addGuestPlayerResponse")
    public JAXBElement<AddGuestPlayerResponse> createAddGuestPlayerResponse(AddGuestPlayerResponse value) {
        return new JAXBElement<AddGuestPlayerResponse>(_AddGuestPlayerResponse_QNAME, AddGuestPlayerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddHostPlayer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "addHostPlayer")
    public JAXBElement<AddHostPlayer> createAddHostPlayer(AddHostPlayer value) {
        return new JAXBElement<AddHostPlayer>(_AddHostPlayer_QNAME, AddHostPlayer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddHostPlayerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "addHostPlayerResponse")
    public JAXBElement<AddHostPlayerResponse> createAddHostPlayerResponse(AddHostPlayerResponse value) {
        return new JAXBElement<AddHostPlayerResponse>(_AddHostPlayerResponse_QNAME, AddHostPlayerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddNewMatch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "addNewMatch")
    public JAXBElement<AddNewMatch> createAddNewMatch(AddNewMatch value) {
        return new JAXBElement<AddNewMatch>(_AddNewMatch_QNAME, AddNewMatch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddNewMatchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "addNewMatchResponse")
    public JAXBElement<AddNewMatchResponse> createAddNewMatchResponse(AddNewMatchResponse value) {
        return new JAXBElement<AddNewMatchResponse>(_AddNewMatchResponse_QNAME, AddNewMatchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddNewMatchToJPA }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "addNewMatchToJPA")
    public JAXBElement<AddNewMatchToJPA> createAddNewMatchToJPA(AddNewMatchToJPA value) {
        return new JAXBElement<AddNewMatchToJPA>(_AddNewMatchToJPA_QNAME, AddNewMatchToJPA.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddNewMatchToJPAResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "addNewMatchToJPAResponse")
    public JAXBElement<AddNewMatchToJPAResponse> createAddNewMatchToJPAResponse(AddNewMatchToJPAResponse value) {
        return new JAXBElement<AddNewMatchToJPAResponse>(_AddNewMatchToJPAResponse_QNAME, AddNewMatchToJPAResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Arbiters }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "arbiters")
    public JAXBElement<Arbiters> createArbiters(Arbiters value) {
        return new JAXBElement<Arbiters>(_Arbiters_QNAME, Arbiters.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArbitersCreateQuery }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "arbitersCreateQuery")
    public JAXBElement<ArbitersCreateQuery> createArbitersCreateQuery(ArbitersCreateQuery value) {
        return new JAXBElement<ArbitersCreateQuery>(_ArbitersCreateQuery_QNAME, ArbitersCreateQuery.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArbitersCreateQueryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "arbitersCreateQueryResponse")
    public JAXBElement<ArbitersCreateQueryResponse> createArbitersCreateQueryResponse(ArbitersCreateQueryResponse value) {
        return new JAXBElement<ArbitersCreateQueryResponse>(_ArbitersCreateQueryResponse_QNAME, ArbitersCreateQueryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateDatabase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "createDatabase")
    public JAXBElement<CreateDatabase> createCreateDatabase(CreateDatabase value) {
        return new JAXBElement<CreateDatabase>(_CreateDatabase_QNAME, CreateDatabase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateDatabaseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "createDatabaseResponse")
    public JAXBElement<CreateDatabaseResponse> createCreateDatabaseResponse(CreateDatabaseResponse value) {
        return new JAXBElement<CreateDatabaseResponse>(_CreateDatabaseResponse_QNAME, CreateDatabaseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateGuestSoccerTeam }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "createGuestSoccerTeam")
    public JAXBElement<CreateGuestSoccerTeam> createCreateGuestSoccerTeam(CreateGuestSoccerTeam value) {
        return new JAXBElement<CreateGuestSoccerTeam>(_CreateGuestSoccerTeam_QNAME, CreateGuestSoccerTeam.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateGuestSoccerTeamResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "createGuestSoccerTeamResponse")
    public JAXBElement<CreateGuestSoccerTeamResponse> createCreateGuestSoccerTeamResponse(CreateGuestSoccerTeamResponse value) {
        return new JAXBElement<CreateGuestSoccerTeamResponse>(_CreateGuestSoccerTeamResponse_QNAME, CreateGuestSoccerTeamResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateHostSoccerTeam }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "createHostSoccerTeam")
    public JAXBElement<CreateHostSoccerTeam> createCreateHostSoccerTeam(CreateHostSoccerTeam value) {
        return new JAXBElement<CreateHostSoccerTeam>(_CreateHostSoccerTeam_QNAME, CreateHostSoccerTeam.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateHostSoccerTeamResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "createHostSoccerTeamResponse")
    public JAXBElement<CreateHostSoccerTeamResponse> createCreateHostSoccerTeamResponse(CreateHostSoccerTeamResponse value) {
        return new JAXBElement<CreateHostSoccerTeamResponse>(_CreateHostSoccerTeamResponse_QNAME, CreateHostSoccerTeamResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAllMatches }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "deleteAllMatches")
    public JAXBElement<DeleteAllMatches> createDeleteAllMatches(DeleteAllMatches value) {
        return new JAXBElement<DeleteAllMatches>(_DeleteAllMatches_QNAME, DeleteAllMatches.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAllMatchesDatabase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "deleteAllMatchesDatabase")
    public JAXBElement<DeleteAllMatchesDatabase> createDeleteAllMatchesDatabase(DeleteAllMatchesDatabase value) {
        return new JAXBElement<DeleteAllMatchesDatabase>(_DeleteAllMatchesDatabase_QNAME, DeleteAllMatchesDatabase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAllMatchesDatabaseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "deleteAllMatchesDatabaseResponse")
    public JAXBElement<DeleteAllMatchesDatabaseResponse> createDeleteAllMatchesDatabaseResponse(DeleteAllMatchesDatabaseResponse value) {
        return new JAXBElement<DeleteAllMatchesDatabaseResponse>(_DeleteAllMatchesDatabaseResponse_QNAME, DeleteAllMatchesDatabaseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAllMatchesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "deleteAllMatchesResponse")
    public JAXBElement<DeleteAllMatchesResponse> createDeleteAllMatchesResponse(DeleteAllMatchesResponse value) {
        return new JAXBElement<DeleteAllMatchesResponse>(_DeleteAllMatchesResponse_QNAME, DeleteAllMatchesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMatchById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "deleteMatchById")
    public JAXBElement<DeleteMatchById> createDeleteMatchById(DeleteMatchById value) {
        return new JAXBElement<DeleteMatchById>(_DeleteMatchById_QNAME, DeleteMatchById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMatchByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "deleteMatchByIdResponse")
    public JAXBElement<DeleteMatchByIdResponse> createDeleteMatchByIdResponse(DeleteMatchByIdResponse value) {
        return new JAXBElement<DeleteMatchByIdResponse>(_DeleteMatchByIdResponse_QNAME, DeleteMatchByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteOneMatchDatabase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "deleteOneMatchDatabase")
    public JAXBElement<DeleteOneMatchDatabase> createDeleteOneMatchDatabase(DeleteOneMatchDatabase value) {
        return new JAXBElement<DeleteOneMatchDatabase>(_DeleteOneMatchDatabase_QNAME, DeleteOneMatchDatabase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteOneMatchDatabaseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "deleteOneMatchDatabaseResponse")
    public JAXBElement<DeleteOneMatchDatabaseResponse> createDeleteOneMatchDatabaseResponse(DeleteOneMatchDatabaseResponse value) {
        return new JAXBElement<DeleteOneMatchDatabaseResponse>(_DeleteOneMatchDatabaseResponse_QNAME, DeleteOneMatchDatabaseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetArbiterName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getArbiterName")
    public JAXBElement<GetArbiterName> createGetArbiterName(GetArbiterName value) {
        return new JAXBElement<GetArbiterName>(_GetArbiterName_QNAME, GetArbiterName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetArbiterNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getArbiterNameResponse")
    public JAXBElement<GetArbiterNameResponse> createGetArbiterNameResponse(GetArbiterNameResponse value) {
        return new JAXBElement<GetArbiterNameResponse>(_GetArbiterNameResponse_QNAME, GetArbiterNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetArbitratorAssistantName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getArbitratorAssistantName")
    public JAXBElement<GetArbitratorAssistantName> createGetArbitratorAssistantName(GetArbitratorAssistantName value) {
        return new JAXBElement<GetArbitratorAssistantName>(_GetArbitratorAssistantName_QNAME, GetArbitratorAssistantName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetArbitratorAssistantNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getArbitratorAssistantNameResponse")
    public JAXBElement<GetArbitratorAssistantNameResponse> createGetArbitratorAssistantNameResponse(GetArbitratorAssistantNameResponse value) {
        return new JAXBElement<GetArbitratorAssistantNameResponse>(_GetArbitratorAssistantNameResponse_QNAME, GetArbitratorAssistantNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetArbitratorAssistantsSize }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getArbitratorAssistantsSize")
    public JAXBElement<GetArbitratorAssistantsSize> createGetArbitratorAssistantsSize(GetArbitratorAssistantsSize value) {
        return new JAXBElement<GetArbitratorAssistantsSize>(_GetArbitratorAssistantsSize_QNAME, GetArbitratorAssistantsSize.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetArbitratorAssistantsSizeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getArbitratorAssistantsSizeResponse")
    public JAXBElement<GetArbitratorAssistantsSizeResponse> createGetArbitratorAssistantsSizeResponse(GetArbitratorAssistantsSizeResponse value) {
        return new JAXBElement<GetArbitratorAssistantsSizeResponse>(_GetArbitratorAssistantsSizeResponse_QNAME, GetArbitratorAssistantsSizeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBasicMatchesInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getBasicMatchesInfo")
    public JAXBElement<GetBasicMatchesInfo> createGetBasicMatchesInfo(GetBasicMatchesInfo value) {
        return new JAXBElement<GetBasicMatchesInfo>(_GetBasicMatchesInfo_QNAME, GetBasicMatchesInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBasicMatchesInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getBasicMatchesInfoResponse")
    public JAXBElement<GetBasicMatchesInfoResponse> createGetBasicMatchesInfoResponse(GetBasicMatchesInfoResponse value) {
        return new JAXBElement<GetBasicMatchesInfoResponse>(_GetBasicMatchesInfoResponse_QNAME, GetBasicMatchesInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGuestPlayerEntryTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getGuestPlayerEntryTime")
    public JAXBElement<GetGuestPlayerEntryTime> createGetGuestPlayerEntryTime(GetGuestPlayerEntryTime value) {
        return new JAXBElement<GetGuestPlayerEntryTime>(_GetGuestPlayerEntryTime_QNAME, GetGuestPlayerEntryTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGuestPlayerEntryTimeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getGuestPlayerEntryTimeResponse")
    public JAXBElement<GetGuestPlayerEntryTimeResponse> createGetGuestPlayerEntryTimeResponse(GetGuestPlayerEntryTimeResponse value) {
        return new JAXBElement<GetGuestPlayerEntryTimeResponse>(_GetGuestPlayerEntryTimeResponse_QNAME, GetGuestPlayerEntryTimeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGuestPlayerFouls }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getGuestPlayerFouls")
    public JAXBElement<GetGuestPlayerFouls> createGetGuestPlayerFouls(GetGuestPlayerFouls value) {
        return new JAXBElement<GetGuestPlayerFouls>(_GetGuestPlayerFouls_QNAME, GetGuestPlayerFouls.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGuestPlayerFoulsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getGuestPlayerFoulsResponse")
    public JAXBElement<GetGuestPlayerFoulsResponse> createGetGuestPlayerFoulsResponse(GetGuestPlayerFoulsResponse value) {
        return new JAXBElement<GetGuestPlayerFoulsResponse>(_GetGuestPlayerFoulsResponse_QNAME, GetGuestPlayerFoulsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGuestPlayerLeftTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getGuestPlayerLeftTime")
    public JAXBElement<GetGuestPlayerLeftTime> createGetGuestPlayerLeftTime(GetGuestPlayerLeftTime value) {
        return new JAXBElement<GetGuestPlayerLeftTime>(_GetGuestPlayerLeftTime_QNAME, GetGuestPlayerLeftTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGuestPlayerLeftTimeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getGuestPlayerLeftTimeResponse")
    public JAXBElement<GetGuestPlayerLeftTimeResponse> createGetGuestPlayerLeftTimeResponse(GetGuestPlayerLeftTimeResponse value) {
        return new JAXBElement<GetGuestPlayerLeftTimeResponse>(_GetGuestPlayerLeftTimeResponse_QNAME, GetGuestPlayerLeftTimeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGuestPlayerName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getGuestPlayerName")
    public JAXBElement<GetGuestPlayerName> createGetGuestPlayerName(GetGuestPlayerName value) {
        return new JAXBElement<GetGuestPlayerName>(_GetGuestPlayerName_QNAME, GetGuestPlayerName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGuestPlayerNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getGuestPlayerNameResponse")
    public JAXBElement<GetGuestPlayerNameResponse> createGetGuestPlayerNameResponse(GetGuestPlayerNameResponse value) {
        return new JAXBElement<GetGuestPlayerNameResponse>(_GetGuestPlayerNameResponse_QNAME, GetGuestPlayerNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGuestPlayerPlayedWholeTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getGuestPlayerPlayedWholeTime")
    public JAXBElement<GetGuestPlayerPlayedWholeTime> createGetGuestPlayerPlayedWholeTime(GetGuestPlayerPlayedWholeTime value) {
        return new JAXBElement<GetGuestPlayerPlayedWholeTime>(_GetGuestPlayerPlayedWholeTime_QNAME, GetGuestPlayerPlayedWholeTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGuestPlayerPlayedWholeTimeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getGuestPlayerPlayedWholeTimeResponse")
    public JAXBElement<GetGuestPlayerPlayedWholeTimeResponse> createGetGuestPlayerPlayedWholeTimeResponse(GetGuestPlayerPlayedWholeTimeResponse value) {
        return new JAXBElement<GetGuestPlayerPlayedWholeTimeResponse>(_GetGuestPlayerPlayedWholeTimeResponse_QNAME, GetGuestPlayerPlayedWholeTimeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGuestPlayerRedCard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getGuestPlayerRedCard")
    public JAXBElement<GetGuestPlayerRedCard> createGetGuestPlayerRedCard(GetGuestPlayerRedCard value) {
        return new JAXBElement<GetGuestPlayerRedCard>(_GetGuestPlayerRedCard_QNAME, GetGuestPlayerRedCard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGuestPlayerRedCardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getGuestPlayerRedCardResponse")
    public JAXBElement<GetGuestPlayerRedCardResponse> createGetGuestPlayerRedCardResponse(GetGuestPlayerRedCardResponse value) {
        return new JAXBElement<GetGuestPlayerRedCardResponse>(_GetGuestPlayerRedCardResponse_QNAME, GetGuestPlayerRedCardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGuestPlayerScoredGoals }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getGuestPlayerScoredGoals")
    public JAXBElement<GetGuestPlayerScoredGoals> createGetGuestPlayerScoredGoals(GetGuestPlayerScoredGoals value) {
        return new JAXBElement<GetGuestPlayerScoredGoals>(_GetGuestPlayerScoredGoals_QNAME, GetGuestPlayerScoredGoals.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGuestPlayerScoredGoalsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getGuestPlayerScoredGoalsResponse")
    public JAXBElement<GetGuestPlayerScoredGoalsResponse> createGetGuestPlayerScoredGoalsResponse(GetGuestPlayerScoredGoalsResponse value) {
        return new JAXBElement<GetGuestPlayerScoredGoalsResponse>(_GetGuestPlayerScoredGoalsResponse_QNAME, GetGuestPlayerScoredGoalsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGuestPlayerYellowCards }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getGuestPlayerYellowCards")
    public JAXBElement<GetGuestPlayerYellowCards> createGetGuestPlayerYellowCards(GetGuestPlayerYellowCards value) {
        return new JAXBElement<GetGuestPlayerYellowCards>(_GetGuestPlayerYellowCards_QNAME, GetGuestPlayerYellowCards.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGuestPlayerYellowCardsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getGuestPlayerYellowCardsResponse")
    public JAXBElement<GetGuestPlayerYellowCardsResponse> createGetGuestPlayerYellowCardsResponse(GetGuestPlayerYellowCardsResponse value) {
        return new JAXBElement<GetGuestPlayerYellowCardsResponse>(_GetGuestPlayerYellowCardsResponse_QNAME, GetGuestPlayerYellowCardsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGuestTeamCoachName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getGuestTeamCoachName")
    public JAXBElement<GetGuestTeamCoachName> createGetGuestTeamCoachName(GetGuestTeamCoachName value) {
        return new JAXBElement<GetGuestTeamCoachName>(_GetGuestTeamCoachName_QNAME, GetGuestTeamCoachName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGuestTeamCoachNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getGuestTeamCoachNameResponse")
    public JAXBElement<GetGuestTeamCoachNameResponse> createGetGuestTeamCoachNameResponse(GetGuestTeamCoachNameResponse value) {
        return new JAXBElement<GetGuestTeamCoachNameResponse>(_GetGuestTeamCoachNameResponse_QNAME, GetGuestTeamCoachNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGuestTeamCountryName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getGuestTeamCountryName")
    public JAXBElement<GetGuestTeamCountryName> createGetGuestTeamCountryName(GetGuestTeamCountryName value) {
        return new JAXBElement<GetGuestTeamCountryName>(_GetGuestTeamCountryName_QNAME, GetGuestTeamCountryName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGuestTeamCountryNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getGuestTeamCountryNameResponse")
    public JAXBElement<GetGuestTeamCountryNameResponse> createGetGuestTeamCountryNameResponse(GetGuestTeamCountryNameResponse value) {
        return new JAXBElement<GetGuestTeamCountryNameResponse>(_GetGuestTeamCountryNameResponse_QNAME, GetGuestTeamCountryNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGuestTeamName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getGuestTeamName")
    public JAXBElement<GetGuestTeamName> createGetGuestTeamName(GetGuestTeamName value) {
        return new JAXBElement<GetGuestTeamName>(_GetGuestTeamName_QNAME, GetGuestTeamName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGuestTeamNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getGuestTeamNameResponse")
    public JAXBElement<GetGuestTeamNameResponse> createGetGuestTeamNameResponse(GetGuestTeamNameResponse value) {
        return new JAXBElement<GetGuestTeamNameResponse>(_GetGuestTeamNameResponse_QNAME, GetGuestTeamNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGuestTeamPlayersSize }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getGuestTeamPlayersSize")
    public JAXBElement<GetGuestTeamPlayersSize> createGetGuestTeamPlayersSize(GetGuestTeamPlayersSize value) {
        return new JAXBElement<GetGuestTeamPlayersSize>(_GetGuestTeamPlayersSize_QNAME, GetGuestTeamPlayersSize.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGuestTeamPlayersSizeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getGuestTeamPlayersSizeResponse")
    public JAXBElement<GetGuestTeamPlayersSizeResponse> createGetGuestTeamPlayersSizeResponse(GetGuestTeamPlayersSizeResponse value) {
        return new JAXBElement<GetGuestTeamPlayersSizeResponse>(_GetGuestTeamPlayersSizeResponse_QNAME, GetGuestTeamPlayersSizeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHostPlayerEntryTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getHostPlayerEntryTime")
    public JAXBElement<GetHostPlayerEntryTime> createGetHostPlayerEntryTime(GetHostPlayerEntryTime value) {
        return new JAXBElement<GetHostPlayerEntryTime>(_GetHostPlayerEntryTime_QNAME, GetHostPlayerEntryTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHostPlayerEntryTimeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getHostPlayerEntryTimeResponse")
    public JAXBElement<GetHostPlayerEntryTimeResponse> createGetHostPlayerEntryTimeResponse(GetHostPlayerEntryTimeResponse value) {
        return new JAXBElement<GetHostPlayerEntryTimeResponse>(_GetHostPlayerEntryTimeResponse_QNAME, GetHostPlayerEntryTimeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHostPlayerFouls }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getHostPlayerFouls")
    public JAXBElement<GetHostPlayerFouls> createGetHostPlayerFouls(GetHostPlayerFouls value) {
        return new JAXBElement<GetHostPlayerFouls>(_GetHostPlayerFouls_QNAME, GetHostPlayerFouls.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHostPlayerFoulsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getHostPlayerFoulsResponse")
    public JAXBElement<GetHostPlayerFoulsResponse> createGetHostPlayerFoulsResponse(GetHostPlayerFoulsResponse value) {
        return new JAXBElement<GetHostPlayerFoulsResponse>(_GetHostPlayerFoulsResponse_QNAME, GetHostPlayerFoulsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHostPlayerLeftTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getHostPlayerLeftTime")
    public JAXBElement<GetHostPlayerLeftTime> createGetHostPlayerLeftTime(GetHostPlayerLeftTime value) {
        return new JAXBElement<GetHostPlayerLeftTime>(_GetHostPlayerLeftTime_QNAME, GetHostPlayerLeftTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHostPlayerLeftTimeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getHostPlayerLeftTimeResponse")
    public JAXBElement<GetHostPlayerLeftTimeResponse> createGetHostPlayerLeftTimeResponse(GetHostPlayerLeftTimeResponse value) {
        return new JAXBElement<GetHostPlayerLeftTimeResponse>(_GetHostPlayerLeftTimeResponse_QNAME, GetHostPlayerLeftTimeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHostPlayerName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getHostPlayerName")
    public JAXBElement<GetHostPlayerName> createGetHostPlayerName(GetHostPlayerName value) {
        return new JAXBElement<GetHostPlayerName>(_GetHostPlayerName_QNAME, GetHostPlayerName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHostPlayerNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getHostPlayerNameResponse")
    public JAXBElement<GetHostPlayerNameResponse> createGetHostPlayerNameResponse(GetHostPlayerNameResponse value) {
        return new JAXBElement<GetHostPlayerNameResponse>(_GetHostPlayerNameResponse_QNAME, GetHostPlayerNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHostPlayerPlayedWholeTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getHostPlayerPlayedWholeTime")
    public JAXBElement<GetHostPlayerPlayedWholeTime> createGetHostPlayerPlayedWholeTime(GetHostPlayerPlayedWholeTime value) {
        return new JAXBElement<GetHostPlayerPlayedWholeTime>(_GetHostPlayerPlayedWholeTime_QNAME, GetHostPlayerPlayedWholeTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHostPlayerPlayedWholeTimeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getHostPlayerPlayedWholeTimeResponse")
    public JAXBElement<GetHostPlayerPlayedWholeTimeResponse> createGetHostPlayerPlayedWholeTimeResponse(GetHostPlayerPlayedWholeTimeResponse value) {
        return new JAXBElement<GetHostPlayerPlayedWholeTimeResponse>(_GetHostPlayerPlayedWholeTimeResponse_QNAME, GetHostPlayerPlayedWholeTimeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHostPlayerRedCard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getHostPlayerRedCard")
    public JAXBElement<GetHostPlayerRedCard> createGetHostPlayerRedCard(GetHostPlayerRedCard value) {
        return new JAXBElement<GetHostPlayerRedCard>(_GetHostPlayerRedCard_QNAME, GetHostPlayerRedCard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHostPlayerRedCardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getHostPlayerRedCardResponse")
    public JAXBElement<GetHostPlayerRedCardResponse> createGetHostPlayerRedCardResponse(GetHostPlayerRedCardResponse value) {
        return new JAXBElement<GetHostPlayerRedCardResponse>(_GetHostPlayerRedCardResponse_QNAME, GetHostPlayerRedCardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHostPlayerScoredGoals }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getHostPlayerScoredGoals")
    public JAXBElement<GetHostPlayerScoredGoals> createGetHostPlayerScoredGoals(GetHostPlayerScoredGoals value) {
        return new JAXBElement<GetHostPlayerScoredGoals>(_GetHostPlayerScoredGoals_QNAME, GetHostPlayerScoredGoals.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHostPlayerScoredGoalsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getHostPlayerScoredGoalsResponse")
    public JAXBElement<GetHostPlayerScoredGoalsResponse> createGetHostPlayerScoredGoalsResponse(GetHostPlayerScoredGoalsResponse value) {
        return new JAXBElement<GetHostPlayerScoredGoalsResponse>(_GetHostPlayerScoredGoalsResponse_QNAME, GetHostPlayerScoredGoalsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHostPlayerYellowCards }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getHostPlayerYellowCards")
    public JAXBElement<GetHostPlayerYellowCards> createGetHostPlayerYellowCards(GetHostPlayerYellowCards value) {
        return new JAXBElement<GetHostPlayerYellowCards>(_GetHostPlayerYellowCards_QNAME, GetHostPlayerYellowCards.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHostPlayerYellowCardsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getHostPlayerYellowCardsResponse")
    public JAXBElement<GetHostPlayerYellowCardsResponse> createGetHostPlayerYellowCardsResponse(GetHostPlayerYellowCardsResponse value) {
        return new JAXBElement<GetHostPlayerYellowCardsResponse>(_GetHostPlayerYellowCardsResponse_QNAME, GetHostPlayerYellowCardsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHostTeamCoachName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getHostTeamCoachName")
    public JAXBElement<GetHostTeamCoachName> createGetHostTeamCoachName(GetHostTeamCoachName value) {
        return new JAXBElement<GetHostTeamCoachName>(_GetHostTeamCoachName_QNAME, GetHostTeamCoachName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHostTeamCoachNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getHostTeamCoachNameResponse")
    public JAXBElement<GetHostTeamCoachNameResponse> createGetHostTeamCoachNameResponse(GetHostTeamCoachNameResponse value) {
        return new JAXBElement<GetHostTeamCoachNameResponse>(_GetHostTeamCoachNameResponse_QNAME, GetHostTeamCoachNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHostTeamCountryName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getHostTeamCountryName")
    public JAXBElement<GetHostTeamCountryName> createGetHostTeamCountryName(GetHostTeamCountryName value) {
        return new JAXBElement<GetHostTeamCountryName>(_GetHostTeamCountryName_QNAME, GetHostTeamCountryName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHostTeamCountryNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getHostTeamCountryNameResponse")
    public JAXBElement<GetHostTeamCountryNameResponse> createGetHostTeamCountryNameResponse(GetHostTeamCountryNameResponse value) {
        return new JAXBElement<GetHostTeamCountryNameResponse>(_GetHostTeamCountryNameResponse_QNAME, GetHostTeamCountryNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHostTeamName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getHostTeamName")
    public JAXBElement<GetHostTeamName> createGetHostTeamName(GetHostTeamName value) {
        return new JAXBElement<GetHostTeamName>(_GetHostTeamName_QNAME, GetHostTeamName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHostTeamNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getHostTeamNameResponse")
    public JAXBElement<GetHostTeamNameResponse> createGetHostTeamNameResponse(GetHostTeamNameResponse value) {
        return new JAXBElement<GetHostTeamNameResponse>(_GetHostTeamNameResponse_QNAME, GetHostTeamNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHostTeamPlayersSize }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getHostTeamPlayersSize")
    public JAXBElement<GetHostTeamPlayersSize> createGetHostTeamPlayersSize(GetHostTeamPlayersSize value) {
        return new JAXBElement<GetHostTeamPlayersSize>(_GetHostTeamPlayersSize_QNAME, GetHostTeamPlayersSize.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHostTeamPlayersSizeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getHostTeamPlayersSizeResponse")
    public JAXBElement<GetHostTeamPlayersSizeResponse> createGetHostTeamPlayersSizeResponse(GetHostTeamPlayersSizeResponse value) {
        return new JAXBElement<GetHostTeamPlayersSizeResponse>(_GetHostTeamPlayersSizeResponse_QNAME, GetHostTeamPlayersSizeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMatchId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getMatchId")
    public JAXBElement<GetMatchId> createGetMatchId(GetMatchId value) {
        return new JAXBElement<GetMatchId>(_GetMatchId_QNAME, GetMatchId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMatchIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getMatchIdResponse")
    public JAXBElement<GetMatchIdResponse> createGetMatchIdResponse(GetMatchIdResponse value) {
        return new JAXBElement<GetMatchIdResponse>(_GetMatchIdResponse_QNAME, GetMatchIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMatchTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getMatchTime")
    public JAXBElement<GetMatchTime> createGetMatchTime(GetMatchTime value) {
        return new JAXBElement<GetMatchTime>(_GetMatchTime_QNAME, GetMatchTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMatchTimeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getMatchTimeResponse")
    public JAXBElement<GetMatchTimeResponse> createGetMatchTimeResponse(GetMatchTimeResponse value) {
        return new JAXBElement<GetMatchTimeResponse>(_GetMatchTimeResponse_QNAME, GetMatchTimeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNumberOfMatches }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getNumberOfMatches")
    public JAXBElement<GetNumberOfMatches> createGetNumberOfMatches(GetNumberOfMatches value) {
        return new JAXBElement<GetNumberOfMatches>(_GetNumberOfMatches_QNAME, GetNumberOfMatches.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNumberOfMatchesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "getNumberOfMatchesResponse")
    public JAXBElement<GetNumberOfMatchesResponse> createGetNumberOfMatchesResponse(GetNumberOfMatchesResponse value) {
        return new JAXBElement<GetNumberOfMatchesResponse>(_GetNumberOfMatchesResponse_QNAME, GetNumberOfMatchesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HasMatchInData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "hasMatchInData")
    public JAXBElement<HasMatchInData> createHasMatchInData(HasMatchInData value) {
        return new JAXBElement<HasMatchInData>(_HasMatchInData_QNAME, HasMatchInData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HasMatchInDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "hasMatchInDataResponse")
    public JAXBElement<HasMatchInDataResponse> createHasMatchInDataResponse(HasMatchInDataResponse value) {
        return new JAXBElement<HasMatchInDataResponse>(_HasMatchInDataResponse_QNAME, HasMatchInDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Matches }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "matches")
    public JAXBElement<Matches> createMatches(Matches value) {
        return new JAXBElement<Matches>(_Matches_QNAME, Matches.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MatchesCreateQuery }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "matchesCreateQuery")
    public JAXBElement<MatchesCreateQuery> createMatchesCreateQuery(MatchesCreateQuery value) {
        return new JAXBElement<MatchesCreateQuery>(_MatchesCreateQuery_QNAME, MatchesCreateQuery.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MatchesCreateQueryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "matchesCreateQueryResponse")
    public JAXBElement<MatchesCreateQueryResponse> createMatchesCreateQueryResponse(MatchesCreateQueryResponse value) {
        return new JAXBElement<MatchesCreateQueryResponse>(_MatchesCreateQueryResponse_QNAME, MatchesCreateQueryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Persist }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "persist")
    public JAXBElement<Persist> createPersist(Persist value) {
        return new JAXBElement<Persist>(_Persist_QNAME, Persist.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersistResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "persistResponse")
    public JAXBElement<PersistResponse> createPersistResponse(PersistResponse value) {
        return new JAXBElement<PersistResponse>(_PersistResponse_QNAME, PersistResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlayerCreateQuery }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "playerCreateQuery")
    public JAXBElement<PlayerCreateQuery> createPlayerCreateQuery(PlayerCreateQuery value) {
        return new JAXBElement<PlayerCreateQuery>(_PlayerCreateQuery_QNAME, PlayerCreateQuery.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlayerCreateQueryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "playerCreateQueryResponse")
    public JAXBElement<PlayerCreateQueryResponse> createPlayerCreateQueryResponse(PlayerCreateQueryResponse value) {
        return new JAXBElement<PlayerCreateQueryResponse>(_PlayerCreateQueryResponse_QNAME, PlayerCreateQueryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Players }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "players")
    public JAXBElement<Players> createPlayers(Players value) {
        return new JAXBElement<Players>(_Players_QNAME, Players.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadDatabaseFromFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "readDatabaseFromFile")
    public JAXBElement<ReadDatabaseFromFile> createReadDatabaseFromFile(ReadDatabaseFromFile value) {
        return new JAXBElement<ReadDatabaseFromFile>(_ReadDatabaseFromFile_QNAME, ReadDatabaseFromFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadDatabaseFromFileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "readDatabaseFromFileResponse")
    public JAXBElement<ReadDatabaseFromFileResponse> createReadDatabaseFromFileResponse(ReadDatabaseFromFileResponse value) {
        return new JAXBElement<ReadDatabaseFromFileResponse>(_ReadDatabaseFromFileResponse_QNAME, ReadDatabaseFromFileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadMatchFromFileDatabase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "readMatchFromFileDatabase")
    public JAXBElement<ReadMatchFromFileDatabase> createReadMatchFromFileDatabase(ReadMatchFromFileDatabase value) {
        return new JAXBElement<ReadMatchFromFileDatabase>(_ReadMatchFromFileDatabase_QNAME, ReadMatchFromFileDatabase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadMatchFromFileDatabaseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "readMatchFromFileDatabaseResponse")
    public JAXBElement<ReadMatchFromFileDatabaseResponse> createReadMatchFromFileDatabaseResponse(ReadMatchFromFileDatabaseResponse value) {
        return new JAXBElement<ReadMatchFromFileDatabaseResponse>(_ReadMatchFromFileDatabaseResponse_QNAME, ReadMatchFromFileDatabaseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveDatabaseToFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "saveDatabaseToFile")
    public JAXBElement<SaveDatabaseToFile> createSaveDatabaseToFile(SaveDatabaseToFile value) {
        return new JAXBElement<SaveDatabaseToFile>(_SaveDatabaseToFile_QNAME, SaveDatabaseToFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveDatabaseToFileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "saveDatabaseToFileResponse")
    public JAXBElement<SaveDatabaseToFileResponse> createSaveDatabaseToFileResponse(SaveDatabaseToFileResponse value) {
        return new JAXBElement<SaveDatabaseToFileResponse>(_SaveDatabaseToFileResponse_QNAME, SaveDatabaseToFileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowDatabaseArbitersList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "showDatabaseArbitersList")
    public JAXBElement<ShowDatabaseArbitersList> createShowDatabaseArbitersList(ShowDatabaseArbitersList value) {
        return new JAXBElement<ShowDatabaseArbitersList>(_ShowDatabaseArbitersList_QNAME, ShowDatabaseArbitersList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowDatabaseArbitersListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "showDatabaseArbitersListResponse")
    public JAXBElement<ShowDatabaseArbitersListResponse> createShowDatabaseArbitersListResponse(ShowDatabaseArbitersListResponse value) {
        return new JAXBElement<ShowDatabaseArbitersListResponse>(_ShowDatabaseArbitersListResponse_QNAME, ShowDatabaseArbitersListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowDatabaseMatchesList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "showDatabaseMatchesList")
    public JAXBElement<ShowDatabaseMatchesList> createShowDatabaseMatchesList(ShowDatabaseMatchesList value) {
        return new JAXBElement<ShowDatabaseMatchesList>(_ShowDatabaseMatchesList_QNAME, ShowDatabaseMatchesList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowDatabaseMatchesListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "showDatabaseMatchesListResponse")
    public JAXBElement<ShowDatabaseMatchesListResponse> createShowDatabaseMatchesListResponse(ShowDatabaseMatchesListResponse value) {
        return new JAXBElement<ShowDatabaseMatchesListResponse>(_ShowDatabaseMatchesListResponse_QNAME, ShowDatabaseMatchesListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowDatabasePlayersList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "showDatabasePlayersList")
    public JAXBElement<ShowDatabasePlayersList> createShowDatabasePlayersList(ShowDatabasePlayersList value) {
        return new JAXBElement<ShowDatabasePlayersList>(_ShowDatabasePlayersList_QNAME, ShowDatabasePlayersList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowDatabasePlayersListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "showDatabasePlayersListResponse")
    public JAXBElement<ShowDatabasePlayersListResponse> createShowDatabasePlayersListResponse(ShowDatabasePlayersListResponse value) {
        return new JAXBElement<ShowDatabasePlayersListResponse>(_ShowDatabasePlayersListResponse_QNAME, ShowDatabasePlayersListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowDatabaseTeamList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "showDatabaseTeamList")
    public JAXBElement<ShowDatabaseTeamList> createShowDatabaseTeamList(ShowDatabaseTeamList value) {
        return new JAXBElement<ShowDatabaseTeamList>(_ShowDatabaseTeamList_QNAME, ShowDatabaseTeamList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowDatabaseTeamListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "showDatabaseTeamListResponse")
    public JAXBElement<ShowDatabaseTeamListResponse> createShowDatabaseTeamListResponse(ShowDatabaseTeamListResponse value) {
        return new JAXBElement<ShowDatabaseTeamListResponse>(_ShowDatabaseTeamListResponse_QNAME, ShowDatabaseTeamListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Team }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "team")
    public JAXBElement<Team> createTeam(Team value) {
        return new JAXBElement<Team>(_Team_QNAME, Team.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TeamCreateQuery }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "teamCreateQuery")
    public JAXBElement<TeamCreateQuery> createTeamCreateQuery(TeamCreateQuery value) {
        return new JAXBElement<TeamCreateQuery>(_TeamCreateQuery_QNAME, TeamCreateQuery.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TeamCreateQueryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", name = "teamCreateQueryResponse")
    public JAXBElement<TeamCreateQueryResponse> createTeamCreateQueryResponse(TeamCreateQueryResponse value) {
        return new JAXBElement<TeamCreateQueryResponse>(_TeamCreateQueryResponse_QNAME, TeamCreateQueryResponse.class, null, value);
    }

}
