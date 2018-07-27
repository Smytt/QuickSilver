/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE IF NOT EXISTS `quicksilver` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `quicksilver`;

CREATE TABLE IF NOT EXISTS `favorites` (
  `user_id` int(11) NOT NULL,
  `movie_id` int(11) NOT NULL,
  `added_on` datetime NOT NULL DEFAULT current_timestamp(),
  UNIQUE KEY `user_id_movie_id` (`user_id`,`movie_id`),
  KEY `fav_user_fk` (`user_id`),
  KEY `fav_movie_fk` (`movie_id`),
  CONSTRAINT `fav_movie_fk` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`),
  CONSTRAINT `fav_user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `favorites` DISABLE KEYS */;
INSERT INTO `favorites` (`user_id`, `movie_id`, `added_on`) VALUES
	(1, 16, '2018-07-26 14:20:35'),
	(2, 7, '2018-07-26 14:19:31'),
	(3, 25, '2018-07-26 14:20:28'),
	(4, 3, '2018-07-26 14:19:31'),
	(4, 17, '2018-07-26 14:19:31'),
	(5, 21, '2018-07-26 14:21:55');
/*!40000 ALTER TABLE `favorites` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `movies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` text NOT NULL,
  `summary` text NOT NULL,
  `poster` text NOT NULL,
  `year` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` (`id`, `title`, `summary`, `poster`, `year`) VALUES
	(1, 'The Matrix', 'A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.', 'https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SY1000_CR0,0,665,1000_AL_.jpg', 1999),
	(2, 'Interstellar', 'Earth\'s future has been riddled by disasters, famines, and droughts. There is only one way to ensure mankind\'s survival: Interstellar travel. A newly discovered wormhole in the far reaches of our solar system allows a team of astronauts to go where no man has gone before, a planet that may have the right environment to sustain human life.', 'https://m.media-amazon.com/images/M/MV5BZjdkOTU3MDktN2IxOS00OGEyLWFmMjktY2FiMmZkNWIyODZiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SY1000_SX675_AL_.jpg', 2014),
	(3, 'Inception', 'Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing valuable secrets from deep within the subconscious during the dream state, when the mind is at its most vulnerable. Cobb\'s rare ability has made him a coveted player in this treacherous new world of corporate espionage, but it has also made him an international fugitive and cost him everything he has ever loved. Now Cobb is being offered a chance at redemption. One last job could give him his life back but only if he can accomplish the impossible - inception. Instead of the perfect heist, Cobb and his team of specialists have to pull off the reverse: their task is not to steal an idea but to plant one. If they succeed, it could be the perfect crime. But no amount of careful planning or expertise can prepare the team for the dangerous enemy that seems to predict their every move. An enemy that only Cobb could have seen coming.', 'https://www.imdb.com/title/tt1375666/mediaviewer/rm3426651392', 2010),
	(4, 'The Dark Knight', 'Set within a year after the events of Batman Begins, Batman, Lieutenant James Gordon, and new district attorney Harvey Dent successfully begin to round up the criminals that plague Gotham City until a mysterious and sadistic criminal mastermind known only as the Joker appears in Gotham, creating a new wave of chaos. Batman\'s struggle against the Joker becomes deeply personal, forcing him to "confront everything he believes" and improve his technology to stop him. A love triangle develops between Bruce Wayne, Dent and Rachel Dawes.', 'https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_SY1000_CR0,0,675,1000_AL_.jpg', 2008),
	(5, 'The Lord of the Rings: The Fellowship of the Ring', 'An ancient Ring thought lost for centuries has been found, and through a strange twist in fate has been given to a small Hobbit named Frodo. When Gandalf discovers the Ring is in fact the One Ring of the Dark Lord Sauron, Frodo must make an epic quest to the Cracks of Doom in order to destroy it! However he does not go alone. He is joined by Gandalf, Legolas the elf, Gimli the Dwarf, Aragorn, Boromir and his three Hobbit friends Merry, Pippin and Samwise. Through mountains, snow, darkness, forests, rivers and plains, facing evil and danger at every corner the Fellowship of the Ring must go. Their quest to destroy the One Ring is the only hope for the end of the Dark Lords reign!', 'https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_SY999_CR0,0,673,999_AL_.jpg', 2001),
	(6, 'Face/Off', 'Sean Archer, a very tough, rugged FBI Agent, is still grieving for his dead son Michael. Archer believes that his son\'s killer is his sworn enemy and a very powerful criminal, Castor Troy. One day, Archer has finally cornered Castor, however, their fight has knocked out Troy cold. As Archer finally breathes easy over the capture of his enemy, he finds out that Troy has planted a bomb that will destroy the entire city of Los Angeles and all of its inhabitants. Unfortunately the only other person who knows its location is Castor\'s brother Pollux, and he refuses to talk. The solution, a special operation doctor that can cut off people\'s faces, and can place a person\'s face onto another person. Archer undergoes one of those surgeries to talk to Pollux. However, Castor Troy somehow regains consciousness and now wants revenge on Archer for taking his face. Not only is Troy ruining Archer\'s mission, but his personal life as well. Archer must stop Troy again. This time, it\'s personal.', 'https://m.media-amazon.com/images/M/MV5BYzFjNzIxMmEtMzY5NS00YTgzLTkwYWEtN2FjMmY0NmNkZWY3XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_.jpg', 1997),
	(7, 'Gone in Sixty Seconds', 'Car theft in Long Beach went down 47% when Randall "Memphis" Raines walked away from the life. He gets dragged back into it by assuming the job his brother Kip screwed up for stolen-car broker Raymond Calitri: steal 50 exotic cars and have them on a container ship by 8 AM Friday morning, and he got this news on a Monday. With Calitri threatening to kill him and Kip, and the police GRAB unit breathing down his neck, Memphis reassembles his old crew and attempts to pull off the logistically impossible.', 'https://m.media-amazon.com/images/M/MV5BMTIwMzExNDEwN15BMl5BanBnXkFtZTYwODMxMzg2._V1_.jpg', 2000),
	(8, 'Wanted', 'A young man finds out his long lost father is an assassin. When his father is murdered, the son is recruited into his father\'s old organization and trained by a man named Sloan to follow in his dad\'s footsteps.', 'https://m.media-amazon.com/images/M/MV5BMTQwNDM2MTMwMl5BMl5BanBnXkFtZTgwMjE4NjQxMTE@._V1_SY1000_CR0,0,665,1000_AL_.jpg', 2008),
	(9, 'Mr. & Mrs. Smith', 'John and Jane Smith are a normal married couple, living a normal life in a normal suburb, working normal jobs...well, if you can call secretly being assassins "normal". But neither Jane nor John knows about their spouse\'s secret, until they are surprised to find each other as targets! But on their quest to kill each other, they learn a lot more about each other than they ever did in five (or six) years of marriage.', 'https://m.media-amazon.com/images/M/MV5BMTUxMzcxNzQzOF5BMl5BanBnXkFtZTcwMzQxNjUyMw@@._V1_SY1000_CR0,0,678,1000_AL_.jpg', 2005),
	(10, 'The Tourist', 'Elise (Angelina Jolie) sits next to an American tourist, Frank (Johnny Depp), on a train going to Venice. She has chosen him as a decoy, making believe that he is her lover who is wanted by police. Not only will they need to evade the police, but also the mobster whose money her lover stole.', 'https://m.media-amazon.com/images/M/MV5BMTMyMzc3OTkwMV5BMl5BanBnXkFtZTcwMjc0MTgwNA@@._V1_SY1000_CR0,0,674,1000_AL_.jpg', 2010),
	(11, 'The Da Vinci Code', 'Professor Robert Langdon is in Paris on business when he\'s summoned to The Louvre. A dead body has been found, setting Langdon off on an adventure as he attempts to unravel an ancient code and uncover the greatest mystery of all time.', 'https://m.media-amazon.com/images/M/MV5BMjIxMjQyMTc3Nl5BMl5BanBnXkFtZTcwMTA1MDUzMw@@._V1_SY1000_CR0,0,672,1000_AL_.jpg', 2006),
	(12, 'Home Alone', 'It is Christmas time and the McCallister family is preparing for a vacation in Paris, France. But the youngest in the family named Kevin got into a scuffle with his older brother Buzz and was sent to his room which is on the third floor of his house. Then, the next morning, while the rest of the family was in a rush to make it to the airport on time, they completely forgot about Kevin who now has the house all to himself. Being home alone was fun for Kevin, having a pizza all to himself, jumping on his parents\' bed, and making a mess. Then, Kevin discovers about two burglars, Harry and Marv, about to rob his house on Christmas Eve. Kevin acts quickly by wiring his own house with makeshift booby traps to stop the burglars and to bring them to justice.', 'https://m.media-amazon.com/images/M/MV5BMzFkM2YwOTQtYzk2Mi00N2VlLWE3NTItN2YwNDg1YmY0ZDNmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SY1000_CR0,0,672,1000_AL_.jpg', 1990),
	(13, 'Captain America: Civil War', 'With many people fearing the actions of super heroes, the government decides to push for the Hero Registration Act, a law that limits a hero\'s actions. This results in a division in The Avengers. Iron Man stands with this Act, claiming that their actions must be kept in check otherwise cities will continue to be destroyed, but Captain America feels that saving the world is daring enough and that they cannot rely on the government to protect the world. This escalates into an all-out war between Team Iron Man (Iron Man, Black Panther, Vision, Black Widow, War Machine, and Spider-Man) and Team Captain America (Captain America, Bucky Barnes, Falcon, Scarlet Witch, Hawkeye, and Ant Man) while a new villain emerges.', 'https://m.media-amazon.com/images/M/MV5BMjQ0MTgyNjAxMV5BMl5BanBnXkFtZTgwNjUzMDkyODE@._V1_SY1000_CR0,0,674,1000_AL_.jpg', 2016),
	(14, 'Doctor Strange', 'Marvel\'s "Doctor Strange" follows the story of the talented neurosurgeon Doctor Stephen Strange who, after a tragic car accident, must put ego aside and learn the secrets of a hidden world of mysticism and alternate dimensions. Based in New York City\'s Greenwich Village, Doctor Strange must act as an intermediary between the real world and what lies beyond, utilising a vast array of metaphysical abilities and artifacts to protect the Marvel Cinematic Universe.', 'https://m.media-amazon.com/images/M/MV5BNjgwNzAzNjk1Nl5BMl5BanBnXkFtZTgwMzQ2NjI1OTE@._V1_SY1000_CR0,0,674,1000_AL_.jpg', 2016),
	(15, 'Spider-Man: Homecoming', 'Thrilled by his experience with the Avengers, Peter returns home, where he lives with his Aunt May, under the watchful eye of his new mentor Tony Stark, Peter tries to fall back into his normal daily routine - distracted by thoughts of proving himself to be more than just your friendly neighborhood Spider-Man - but when the Vulture emerges as a new villain, everything that Peter holds most important will be threatened', 'https://m.media-amazon.com/images/M/MV5BNTk4ODQ1MzgzNl5BMl5BanBnXkFtZTgwMTMyMzM4MTI@._V1_SY1000_CR0,0,658,1000_AL_.jpg', 2017),
	(16, 'Avatar', 'When his brother is killed in a robbery, paraplegic Marine Jake Sully decides to take his place in a mission on the distant world of Pandora. There he learns of greedy corporate figurehead Parker Selfridge\'s intentions of driving off the native humanoid "Na\'vi" in order to mine for the precious material scattered throughout their rich woodland. In exchange for the spinal surgery that will fix his legs, Jake gathers intel for the cooperating military unit spearheaded by gung-ho Colonel Quaritch, while simultaneously attempting to infiltrate the Na\'vi people with the use of an "avatar" identity. While Jake begins to bond with the native tribe and quickly falls in love with the beautiful alien Neytiri, the restless Colonel moves forward with his ruthless extermination tactics, forcing the soldier to take a stand - and fight back in an epic battle for the fate of Pandora.', 'https://m.media-amazon.com/images/M/MV5BMTYwOTEwNjAzMl5BMl5BanBnXkFtZTcwODc5MTUwMw@@._V1_.jpg', 2009),
	(17, 'Life of P', 'In Canada, a writer visits the Indian storyteller Pi Patel and asks him to tell his life story. Pi tells the story of his childhood in Pondicherry, India, and the origin of his nickname. One day, his father, a zoo owner, explains that the municipality is no longer supporting the zoo and he has hence decided to move to Canada, where the animals the family owns would also be sold. They board on a Japanese cargo ship with the animals and out of the blue, there is a storm, followed by a shipwrecking. Pi survives in a lifeboat with a zebra, an orangutan, a hyena and a male Bengal tiger nicknamed Richard Parker. They are adrift in the Pacific Ocean, with aggressive hyena and Richard Parker getting hungry. Pi needs to find a way to survive.', 'https://m.media-amazon.com/images/M/MV5BNTg2OTY2ODg5OF5BMl5BanBnXkFtZTcwODM5MTYxOA@@._V1_.jpg', 2012),
	(18, 'Gravity', 'Dr. Ryan Stone (Sandra Bullock) is a brilliant medical engineer on her first shuttle mission, with veteran astronaut Matt Kowalski (George Clooney) in command of his last flight before retiring. But on a seemingly routine spacewalk, disaster strikes. The shuttle is destroyed, leaving Stone and Kowalsky completely alone - tethered to nothing but each other and spiraling out into the blackness.', 'https://m.media-amazon.com/images/M/MV5BNjE5MzYwMzYxMF5BMl5BanBnXkFtZTcwOTk4MTk0OQ@@._V1_SY1000_CR0,0,675,1000_AL_.jpg', 2013),
	(19, 'The Revenant', 'While exploring uncharted wilderness in 1823, legendary frontiersman Hugh Glass sustains injuries from a brutal bear attack. When his hunting team leaves him for dead, Glass must utilize his survival skills to find a way back home while avoiding natives on their own hunt. Grief-stricken and fueled by vengeance, Glass treks through the wintry terrain to track down John Fitzgerald, the former confidant who betrayed and abandoned him.', 'https://m.media-amazon.com/images/M/MV5BY2FmODc2N2QtYmY3MS00YTMwLWI2NGYtZWRmYWVkNjFjZmI0XkEyXkFqcGdeQXVyNTMxMjgxMzA@._V1_.jpg', 2015),
	(20, 'The Martian', 'During a manned mission to Mars, Astronaut Mark Watney is presumed dead after a fierce storm and left behind by his crew. But Watney has survived and finds himself stranded and alone on the hostile planet. With only meager supplies, he must draw upon his ingenuity, wit and spirit to subsist and find a way to signal to Earth that he is alive. Millions of miles away, NASA and a team of international scientists work tirelessly to bring "the Martian" home, while his crewmates concurrently plot a daring, if not impossible, rescue mission. As these stories of incredible bravery unfold, the world comes together to root for Watney\'s safe return.', 'https://m.media-amazon.com/images/M/MV5BMTc2MTQ3MDA1Nl5BMl5BanBnXkFtZTgwODA3OTI4NjE@._V1_SY1000_CR0,0,675,1000_AL_.jpg', 2015),
	(21, 'Arrival', 'Linguistics professor Louise Banks leads an elite team of investigators when gigantic spaceships touchdown in 12 locations around the world. As nations teeter on the verge of global war, Banks and her crew must race against time to find a way to communicate with the extraterrestrial visitors. Hoping to unravel the mystery, she takes a chance that could threaten her life and quite possibly all of mankind.', 'https://m.media-amazon.com/images/M/MV5BMTExMzU0ODcxNDheQTJeQWpwZ15BbWU4MDE1OTI4MzAy._V1_SY1000_CR0,0,640,1000_AL_.jpg', 2016),
	(22, 'Ted', 'John makes a Christmas miracle happen by bringing his one and only friend to life, his teddy bear. The two grow up together and John must then choose to stay with his girlfriend or keep his friendship with his crude and extremely inappropriate teddy bear, Ted.', 'https://m.media-amazon.com/images/M/MV5BMTQ1OTU0ODcxMV5BMl5BanBnXkFtZTcwOTMxNTUwOA@@._V1_SY1000_CR0,0,631,1000_AL_.jpg', 2012),
	(23, 'The Hangover', 'Angelenos Doug Billings and Tracy Garner are about to get married. Two days before the wedding, the four men in the wedding party - Doug, Doug\'s two best buddies Phil Wenneck and Stu Price, and Tracy\'s brother Alan Garner - hop into Tracy\'s father\'s beloved Mercedes convertible for a 24-hour stag party to Las Vegas. Phil, a married high school teacher, has the same maturity level as his students when he\'s with his pals. Stu, a dentist, is worried about everything, especially what his controlling girlfriend Melissa thinks. Because she disapproves of traditional male bonding rituals, Stu has to lie to her about the stag, he telling her that they are going on a wine tasting tour in the Napa Valley. Regardless, he intends on eventually marrying her, against the advice and wishes of his friends. And Alan seems to be unaware of what are considered the social graces of the western world.', 'https://m.media-amazon.com/images/M/MV5BNDAxMTZmZGItZmM2NC00M2E1LWI1NmEtZjhhODM2MGU0ZmJlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX675_CR0,0,675,999_AL_.jpg', 2009),
	(24, '22 Jump Street', 'After making their way through high school (twice), big changes are in store for officers Schmidt (Jonah Hill) and Jenko (Channing Tatum) when they go deep undercover at a local college. But when Jenko meets a kindred spirit on the football team, and Schmidt infiltrates the bohemian art major scene, they begin to question their partnership. Now they don\'t have to just crack the case - they have to figure out if they can have a mature relationship. If these two overgrown adolescents can grow from freshmen into real men, college might be the best thing that ever happened to them.', 'https://m.media-amazon.com/images/M/MV5BMTcwNzAxMDU1M15BMl5BanBnXkFtZTgwNDE2NTU1MTE@._V1_SY1000_CR0,0,674,1000_AL_.jpg', 2014),
	(25, 'Neighbors', 'Kelly and Mac are settling down in a quiet neighborhood with their newborn child, until the frat brothers move into the house next door. Teddy is the President, and Pete is his right hand man, and they\'re quick to accept friendship when Kelly and Mac introduce themselves as the neighbors. Night after night, Mac asks Teddy to lower the fraternity\'s noise, even accepting the invitation to the party one evening. When Teddy goes back on his word to keep the partying down, Mac calls the police to deal with the problem. The police quickly blame Mac for their presence, and the war begins. As the family feuds with the frat brothers, things get hilariously dangerous and the fraternity ends up on thin ice with their college. After receiving their final warning and being placed on probation, Mac and Kelly pull a prank so ingenious that Teddy and Pete are forced to respond.', 'https://m.media-amazon.com/images/M/MV5BOTQ0OTkzODgyNF5BMl5BanBnXkFtZTgwOTA3OTE4MDE@._V1_.jpg', 2014);
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `username`, `password`) VALUES
	(1, 'gery7242', 'gery1a'),
	(2, 'pesho2891', 'pesho1a'),
	(3, 'filip1732', 'filip1a'),
	(4, 'alex7590', 'alex1a'),
	(5, 'pavel8791', 'pavel1a'),
	(6, 'kiko', 'pass'),
	(7, 'pesho', 'pass'),
	(23, 'kik11212334o', '1234'),
	(25, 'kik112sdf12334o', '1234'),
	(26, 'kik11d2sdf12334o', '1234'),
	(27, 'hb7tg', 'pass'),
	(28, 'i0dt3', 'pass'),
	(31, 'w6m3p', 'pass');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `watchlist` (
  `user_id` int(11) NOT NULL,
  `movie_id` int(11) NOT NULL,
  `note` text DEFAULT NULL,
  UNIQUE KEY `user_id_movie_id` (`user_id`,`movie_id`),
  KEY `user_fk` (`user_id`),
  KEY `wl_movie_fk` (`movie_id`),
  CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `wl_movie_fk` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `watchlist` DISABLE KEYS */;
INSERT INTO `watchlist` (`user_id`, `movie_id`, `note`) VALUES
	(1, 3, 'watchlater'),
	(1, 8, 'watchlater'),
	(1, 11, 'watchlater'),
	(1, 15, 'watchlater'),
	(1, 17, 'watchlater'),
	(1, 24, 'watchlater'),
	(2, 3, 'watchlater'),
	(2, 6, 'watchlater'),
	(2, 17, 'watchlater'),
	(2, 21, 'watchlater'),
	(2, 22, 'watchlater'),
	(2, 24, 'watchlater'),
	(3, 9, 'watchlater'),
	(3, 15, 'watchlater'),
	(3, 19, 'watchlater'),
	(3, 21, 'watchlater'),
	(3, 24, 'watchlater'),
	(4, 11, 'watchlater'),
	(4, 13, 'watchlater'),
	(4, 19, 'watchlater'),
	(4, 25, 'watchlater'),
	(5, 7, 'watchlater'),
	(5, 11, 'watchlater'),
	(5, 13, 'watchlater'),
	(5, 15, 'watchlater'),
	(5, 16, 'watchlater'),
	(5, 19, 'watchlater'),
	(5, 24, 'watchlater');
/*!40000 ALTER TABLE `watchlist` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
