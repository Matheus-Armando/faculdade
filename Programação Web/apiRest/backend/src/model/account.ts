import { BaseEntity, Column, Entity, PrimaryGeneratedColumn } from "typeorm";

@Entity()
export class account extends BaseEntity {
    
    @PrimaryGeneratedColumn()
    id: number;
    
    @Column()
    player: string;
    
    @Column()
    level: number;

    @Column()
    stars: number;
    
    @Column({ nullable: true })
    dataDownload?: Date;
}