--------------------------------
--SELECT SOLUTIONS TO SQLZOO.NET
--------------------------------

------------------------
-- Solutions to problems listed on 
-- https://sqlzoo.net/wiki/More_JOIN_operations
-------------------------

-- Entity relationship diagram
--
-- movie(id PK, title, yr, score, votes, director FK)
--   director -> actor.id
-- 
-- actor(id PK, name)
--
-- casting(movieid PK FK, actorid PK FK, ord)
--   movieid -> movie.id
--   actorid -> actor.id
------------------------

--15. List all the people who have worked with 'Art Garfunkel'. 

select name from actor
join casting on actor.id=actorid
where name<>'Art Garfunkel' and movieid in
(select movieid from actor
join casting on actor.id=actorid
where name='Art Garfunkel')

--14. List the films released in the year 1978 ordered by the number of actors in the cast, then by title. 

select title, count(actorid) 
from movie 
join casting on movie.id=movieid
where yr=1978
group by title
order by count(*) desc, title

--13. Obtain a list, in alphabetical order, of actors who've had at least 15 starring roles. 

select name from actor
join casting on actor.id=actorid
where ord=1
group by name
having count(*)>=15
order by name

--12. List the film title and the leading actor for all of the films 'Julie Andrews' played in. 

select title, name from movie 
join casting on movie.id=movieid
join actor on actor.id=actorid
where ord=1 and movie.id in 
  (select movieid
  from casting join actor on actorid=actor.id
  where actorid=
    (select id from actor where name='Julie Andrews'))


--11. Which were the busiest years for 'Rock Hudson', show the year and the number of movies he made each year for any year in which he made more than 2 movies. 

select yr, count(*) from movie 
  join casting on movie.id=movieid
  join actor on actor.id=actorid
where name='Rock Hudson'
group by yr
having count(*) > 2
order by yr

--10. List the films together with the leading star for all 1962 films. 

select title, name from movie 
join casting on movie.id=movieid
join actor on actor.id=actorid
where yr=1962 and ord=1

--9, List the films where 'Harrison Ford' has appeared - but not in the starring role. [Note: the ord field of casting gives the position of the actor. If ord=1 then this actor is in the starring role] 

select title
from movie join casting on id=movieid
where actorid=(select id from actor where name='Harrison Ford') and ord>1
order by yr

--8. List the films in which 'Harrison Ford' has appeared 

select title
from movie join casting on id=movieid
where actorid=(select id from actor where name='Harrison Ford')
order by yr

--7. Obtain the cast list for the film 'Alien' 

select name
from actor join casting on id=actorid
where movieid=(select id from movie where title='Alien')

--6. Obtain the cast list for 'Casablanca'. 

select name
from actor join casting on id=actorid
where movieid=(select id from movie where title='Casablanca')

------------------------
-- Solutions to problems listed on 
-- https://sqlzoo.net/wiki/The_JOIN_operation
------------------------

-- Entity relationship diagram
--
-- goal(matchid PK FK,teamid FK, player, gtime PK)
--   teamid -> eteam.id
--   matchid -> game.id
--
-- game(id PK, mdate, stadium, team1 FK, team2 FK) 
--   team1, team2 -> eteam.id
--
-- eteam(id PK, teamname, coach)

--12. For every match where 'GER' scored, show matchid, match date and the number of goals scored by 'GER'

select matchid, mdate, count(*) as 'Germany goals'
from game join goal on matchid=id
where teamid='GER'
group by matchid, mdate
order by count(*) desc

--11. For every match involving 'POL', show the matchid, date and the number of goals scored.

select id, mdate, count(*) as 'Num goals'
from game join goal on id=matchid
where team1='POL' or team2='POL'
group by id, mdate

--10. Show the stadium and the number of goals scored in each stadium.

select stadium, count(*) as 'Num goals'
from game join goal on matchid=id
group by stadium
order by count(*) desc

--9. Show teamname and the total number of goals scored.

select teamname, count(*) as 'Num goals'
from eteam join goal on teamid=id
group by teamname
order by count(*) desc

--8. Instead show the name of all players who scored a goal against Germany.

select distinct player from goal join game on matchid=id
where teamid<>'GER' and (team1='GER' or team2='GER')

--7. List the player for every goal scored in a game where the stadium was 'National Stadium, Warsaw'

select player 
from goal join game on (matchid=id)
where stadium='National Stadium, Warsaw'

--6. List the dates of the matches and the name of the team in which 'Fernando Santos' was the team1 coach.

select mdate, teamname
from game join eteam on (team1=eteam.id)
where coach='Fernando Santos'

--5. Show player, teamid, coach, gtime for all goals scored in the first 10 minutes gtime<=10

SELECT player, teamid, coach, gtime 
FROM goal join eteam on teamid=id
WHERE gtime<=10
 
--4. Show the team1, team2 and player for every goal scored by a player called Mario player LIKE 'Mario%'

SELECT team1, team2, player FROM game 
JOIN goal ON (id=matchid)
where player like 'Mario%'

--3. Modify [the code below] to show the player, teamid, stadium and mdate for every German goal.

SELECT player,teamid, stadium, mdate
FROM game JOIN goal ON (id=matchid)
where teamid='GER'

--------------------------
-- Solutions to problems listed on 
-- https://sqlzoo.net/wiki/SELECT_within_SELECT_Tutorial
--------------------------

--5. Show the name and the population of each country in Europe. Show the population as a percentage of the population of Germany.

select name, 
concat(cast(round(population/(select population from world where name='Germany')*100,0) as int),'%')
from world where continent='Europe'

--4. Which country has a population that is more than Canada but less than Poland? Show the name and the population.

select name, population from world 
where population > (select population from world where name='Canada') 
and population < (select population from world where name='Poland')

--3. List the name and continent of countries in the continents containing either Argentina or Australia. Order by name of the country.

select name, continent from world
where continent in 
(select continent from world 
where name='Argentina' or name='Australia')

--2. Show the countries in Europe with a per capita GDP greater than 'United Kingdom'.

select name from world
where continent='Europe' 
and gdp/population > (select gdp/population from world where name='United Kingdom')

----------------
-- Solutions to problems listed on 
-- https://sqlzoo.net/wiki/SUM_and_COUNT
----------------

--8. List the continents that have a total population of at least 100 million. 

select continent from world
group by continent
having sum(population)>100000000

---------------
-- Solutions to problems listed on 
-- https://sqlzoo.net/wiki/The_nobel_table_can_be_used_to_practice_more_SUM_and_COUNT_functions.
----------------

--4. For each subject show the subject and the number of prizes. 

select subject, count(*) from nobel
group by subject
order by count(*) desc

--5. For each subject show the first year that the prize was awarded. 

select subject, min(yr) as 'First year awarded' from nobel
group by subject
order by min(yr)

--6. For each subject show the number of prizes awarded in the year 2000. 

select subject, count(*) from nobel
where yr=2000
group by subject
order by count(*)

--7. Show the number of different winners for each subject. 

select distinct subject, count(distinct winner) from nobel
group by subject

--8. For each subject show how many years have had prizes awarded. 

select subject, count(distinct yr) from nobel
group by subject

--9. Show the years in which three prizes were given for Physics. 

select yr from nobel 
where subject='Physics'
group by yr
having count(subject) = 3

--10. Show winners who have won more than once. 

select winner from nobel
group by winner
having count(winner)>1

--11. Show the years in which three prizes were given for Physics. 

select yr from nobel 
where subject='Physics'
group by yr
having count(subject) = 3

--12. Show the year and subject where 3 prizes were given. Show only years 2000 onwards. 

select yr, subject from nobel
where yr >= 2000
group by yr, subject
having count(winner) =3
