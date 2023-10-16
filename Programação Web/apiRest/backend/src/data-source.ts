import { DataSource, DataSourceOptions } from "typeorm";
export const dataSourceOptions: DataSourceOptions = {
    type: "postgres",
    host: "localhost",
    port: 5432,
    username: "postgres",
    password: "1",
    database: "apiRest",
    synchronize: true,
    logging: false,
    entities: [__dirname + '/model/**/*.{js,ts}'], 
};
export const AppDataSource = new DataSource({ ...dataSourceOptions });
export const Maintenance = new DataSource({ ...dataSourceOptions, database: "postgres", entities: [] });

export const Server = {url: "http://localhost:4567/"}