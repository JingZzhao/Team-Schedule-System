package service;

import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Programmer;

/**
 * @Auther: Jing Zhao
 * @Date: 8/5/2022 - 08 - 05 - 4:35 PM
 * @Description: Management of development team members: add member/remove member
 * @version: 1.0
 */
public class TeamService {
    private int counter = 1; // Generate members' ID automatically.
    private final int MAX_MEMBER = 5; // team members limit number
    private Programmer[] team = new Programmer[MAX_MEMBER]; // save current team members
    private int total = 0; //the actual number of the team members

    public TeamService() {
    }

    /**
     *
     * @return Returns all employees of the current team
     */
    public Programmer[] getTeam(){
        Programmer[] team = new Programmer[total];

        for(int i = 0; i < total; i ++){
            team[i] = this.team[i];
        }
        return team;
    }

    /**
     * Add employees to the team.
     * @throws TeamException : Failed to add.
     */
    public void addMember(Employee e) throws TeamException {
        if(total >= MAX_MEMBER ){
            throw new TeamException("Team is full, the member cannot be added!");
        }
        if(! (e instanceof Programmer)){
            throw new TeamException("This member is not a programmer!");
        }

        Programmer p = (Programmer) e;

        if(isExist(p)){
            throw new TeamException("This member is already in the team!");
        }

        if(p.getStatus().getNAME().equals("BUSY")){
            throw new TeamException("This member has already belong to a team! ");
        }else if(p.getStatus().getNAME().equals("VOCATION")){
            throw new TeamException("This member is on vocation, cannot be added!");
        }

        int numOfArch = 0, numOfDesg = 0, numOfProg = 0;

        for(int i = 0; i < total; i++){
            if(team[i] instanceof Architect) numOfArch++;
            else if (team[i] instanceof Designer) numOfDesg++;
            else if (team[i] instanceof Programmer) numOfProg++;
        }

        if(p instanceof Architect){
            if(numOfArch >= 1) throw new TeamException("There can be at most one architect in the team!");
        }else if(p instanceof Designer){
            if(numOfDesg >= 2) throw new TeamException("There can be at most two designers in the team!");
        }else if(p instanceof Programmer){
            if(numOfProg >= 3) throw new TeamException("There can be at most three programmers in the team!");
        }

        //add employee into the team
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
        team[total++] = p;

    }

    private Boolean isExist(Programmer p){
        for(int i = 0; i < total; i++){
            if(team[i].getId() == p.getId()){
                return true;
            }
        }
        return false;
    }

    /**
     * Remove member with specific member id from the team.
     * @param memberId: Member id of the member to be deleted from the team.
     * @throws TeamException : Failed to delete.
     */
    public void removeMember(int memberId) throws TeamException {
        int n = 0;
        //find member by memberId, remove it.
        for(; n < total; n++){
            if(team[n].getMemberId() == memberId){
                team[n].setStatus(Status.FREE);
                break;
            }
        }

        //if can't find the member, throw exception
        if(n == total){
            throw new TeamException("The member could not be found and cannot be deleted!");
        }
        //element forward
        for(int i = n + 1; i < total; i++){
            team[i - 1] = team[i];
        }
        team[--total] = null;
    }

}
