use std::collections::HashMap;
use std::rc::Rc;

pub fn read_line() -> String {
    use std::io::stdin;

    let mut buffer = String::new();
    let mut stdin = stdin();
    stdin.read_line(&mut buffer).unwrap();

    buffer.replace("\n", "")
}

fn main() {
    let tc = read_line().parse::<u32>().unwrap();

    for _ in 0..tc {
        let mut counter = Counter {
            count: HashMap::new()
        };
        let points = create_point();
        let circles = create_circle();

        for circle in circles {
            if circle.include(&points[0]) {
                counter.add_count(circle.clone(), PointType::START);
            }
            if circle.include(&points[1]) {
                counter.add_count(circle.clone(), PointType::END);
            }
        }

        println!("{}", counter.find_adjacent_point());
    }
}

fn create_point() -> Vec<Point> {
    let points = create_coordinate();

    vec![Point {
        x: points[0],
        y: points[1],
    }, Point {
        x: points[2],
        y: points[3],
    }]
}

fn create_circle() -> Vec<Rc<Circle>> {
    let mut vec: Vec<Rc<Circle>> = Vec::new();
    let circle_count = read_line().parse::<u32>().unwrap();

    for _ in 0..circle_count {
        let circle_points = create_coordinate();
        vec.push(
            Rc::new(Circle {
                center: Point {
                    x: circle_points[0],
                    y: circle_points[1],
                },
                r: circle_points[2] as u32,
        }));
    }

    vec
}

fn create_coordinate() -> Vec<i32> {
    read_line().split(" ").map(|s| s.parse::<i32>().unwrap()).collect::<Vec<i32>>()
}

#[derive(PartialEq, Eq, Hash)]
enum PointType {
    START,
    END,
}

struct Counter {
    count: HashMap<Rc<Circle>, (u32, u32)>
}

impl Counter {

    fn add_count(&mut self, circle: Rc<Circle>, point_type: PointType) {
        if self.count.contains_key(&circle) == false {
            self.count.insert(circle.clone(), (0, 0));
        }

        let count = self.count.get(&circle).unwrap();

        if point_type == PointType::START {
            self.count.insert(circle, (count.0 + 1, count.1));
        } else {
            self.count.insert(circle, (count.0, count.1 + 1));
        }
    }

    fn find_adjacent_point(&self) -> usize {
        self.count.iter().filter(|&(_, count)| count.0 != count.1).count()
    }
}

#[derive(PartialEq, Eq, Hash)]
struct Circle {
    center: Point,
    r: u32,
}

#[derive(PartialEq, Eq, Hash)]
struct Point {
    x: i32,
    y: i32,
}

impl Circle {

    fn include(&self, p: &Point) -> bool {
        (p.x - self.center.x).pow(2) + (p.y - self.center.y).pow(2)  <= self.r.pow(2) as i32
    }
}