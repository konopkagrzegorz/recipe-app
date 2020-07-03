INSERT INTO category (category_name) VALUES ('American');   --1
INSERT INTO category (category_name) VALUES ('Italian');    --2
INSERT INTO category (category_name) VALUES ('Mexican');    --3
INSERT INTO category (category_name) VALUES ('Fast Food');  --4

INSERT INTO unit_of_measure (uom) VALUES ('Pint');          --1
INSERT INTO unit_of_measure (uom) VALUES ('Dash');          --2
INSERT INTO unit_of_measure (uom) VALUES ('Each');          --3
INSERT INTO unit_of_measure (uom) VALUES ('Teaspoon');      --4
INSERT INTO unit_of_measure (uom) VALUES ('Tablespoon');    --5
INSERT INTO unit_of_measure (uom) VALUES ('Cup');           --6
INSERT INTO unit_of_measure (uom) VALUES ('Pinch');         --7
INSERT INTO unit_of_measure (uom) VALUES ('Ounce');         --8

INSERT INTO notes (note) VALUES ('For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.
Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite).
Try guacamole with added pineapple, mango, or strawberries.
The simplest version of guacamole is just mashed avocados with salt.
Don''t let the lack of availability of other ingredients stop you from making guacamole.
To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip.
 Purists may be horrified, but so what? It tastes great.'); --1

INSERT INTO notes (note) VALUES ('or a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.
Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite).
Try guacamole with added pineapple, mango, or strawberries.
The simplest version of guacamole is just mashed avocados with salt.
Don''t let the lack of availability of other ingredients stop you from making guacamole.
To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip.
 Purists may be horrified, but so what? It tastes great.'); --2

INSERT INTO recipes (description, prep_time, cook_time, servings, source, url, directions, difficulty, image,notes_id) VALUES
('Perfect Guacamole', 10, 0, 4, 'Website', 'http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvpiV9Sd',
'1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.
2 Mash with a fork: Using a fork, roughly mash the avocado. (Don''t overdo it! The guacamole should be a little chunky.)
3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.
Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.
Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.
Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.
4 Serve: Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.'
,'EASY','',1);                                              --1

INSERT INTO recipes (description, prep_time, cook_time, servings, source, url, directions, difficulty, image,notes_id) VALUES
('Spicy Grilled Chicken Taco', 20, 9, 4, 'Website', 'http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvu7Q0MJ',
'1 Prepare a gas or charcoal grill for medium-high, direct heat.
2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over. Set aside to marinate while the grill heats and you prepare the rest of the toppings.
3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.
4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side. Wrap warmed tortillas in a tea towel to keep them warm until serving.
5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.'
,'MODERATE','',2);

UPDATE notes SET recipe_id = 1 WHERE id = 1;
UPDATE notes SET recipe_id = 2 WHERE id = 2;

INSERT INTO ingredient (description, amount, recipe_id, uom_id) VALUES ('ripe avocados',2,1,3);
INSERT INTO ingredient (description, amount, recipe_id, uom_id) VALUES ('Kosher salt',0.5,1,4);
INSERT INTO ingredient (description, amount, recipe_id, uom_id) VALUES ('fresh lime juice or lemon juice',2,1,5);
INSERT INTO ingredient (description, amount, recipe_id, uom_id) VALUES ('minced red onion or thinly sliced green onion',2,1,5);
INSERT INTO ingredient (description, amount, recipe_id, uom_id) VALUES ('serrano chiles, stems and seeds removed, minced',2,1,3);
INSERT INTO ingredient (description, amount, recipe_id, uom_id) VALUES ('Cilantro',2,1,4);
INSERT INTO ingredient (description, amount, recipe_id, uom_id) VALUES ('freshly grated black pepper',2,1,2);
INSERT INTO ingredient (description, amount, recipe_id, uom_id) VALUES ('ripe tomato, seeds and pulp removed, chopped',0.5,1,2);

INSERT INTO recipe_category (recipe_id, category_id) VALUES (1,1);
INSERT INTO recipe_category (recipe_id, category_id) VALUES (1,3);

INSERT INTO ingredient (description, amount, recipe_id, uom_id) VALUES ('Ancho Chili Powder',2,2,5);
INSERT INTO ingredient (description, amount, recipe_id, uom_id) VALUES ('Dried Oregano',1,2,4);
INSERT INTO ingredient (description, amount, recipe_id, uom_id) VALUES ('Dried Cumin',1,2,4);
INSERT INTO ingredient (description, amount, recipe_id, uom_id) VALUES ('Sugar',1,2,4);
INSERT INTO ingredient (description, amount, recipe_id, uom_id) VALUES ('Salt',0.5,2,4);
INSERT INTO ingredient (description, amount, recipe_id, uom_id) VALUES ('Clove of Garlic, Choppedr',1,2,3);
INSERT INTO ingredient (description, amount, recipe_id, uom_id) VALUES ('finely grated orange zestr',1,2,5);
INSERT INTO ingredient (description, amount, recipe_id, uom_id) VALUES ('fresh-squeezed orange juice',3,2,5);
INSERT INTO ingredient (description, amount, recipe_id, uom_id) VALUES ('Olive Oil',2,2,5);
INSERT INTO ingredient (description, amount, recipe_id, uom_id) VALUES ('boneless chicken thighs',4,2,4);
INSERT INTO ingredient (description, amount, recipe_id, uom_id) VALUES ('small corn tortillasr',8,2,3);
INSERT INTO ingredient (description, amount, recipe_id, uom_id) VALUES ('packed baby arugula',3,2,6);
INSERT INTO ingredient (description, amount, recipe_id, uom_id) VALUES ('medium ripe avocados, slic',2,2,3);
INSERT INTO ingredient (description, amount, recipe_id, uom_id) VALUES ('radishes, thinly sliced',4,2,3);
INSERT INTO ingredient (description, amount, recipe_id, uom_id) VALUES ('cherry tomatoes, halved',0.5,2,1);
INSERT INTO ingredient (description, amount, recipe_id, uom_id) VALUES ('red onion, thinly sliced',0.25,2,3);
INSERT INTO ingredient (description, amount, recipe_id, uom_id) VALUES ('Roughly chopped cilantro',4,2,3);
INSERT INTO ingredient (description, amount, recipe_id, uom_id) VALUES ('up sour cream thinned with 1/4 cup milk',4,2,6);
INSERT INTO ingredient (description, amount, recipe_id, uom_id) VALUES ('lime, cut into wedges',4,2,3);

INSERT INTO recipe_category (recipe_id, category_id) VALUES (2,1);
INSERT INTO recipe_category (recipe_id, category_id) VALUES (2,3);