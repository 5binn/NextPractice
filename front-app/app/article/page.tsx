'use client'

import Link from "next/link";
import { useEffect, useState } from "react";


interface ArticleData {
    id: number;
    title: string;
    content: string;
    createdDate: string;
    modifieDDate: string;
}

interface ArticleListResponse {
    resultCode: string;
    msg: string;
    data: {
        articleList: ArticleData[];
    }
}

export default function Article() {

    const [articleList, setArticleList] = useState<ArticleData[]>([]);
    useEffect(() => {
        fetch("http://localhost:8090/api/v1/articles")
        .then(response => response.json())
        .then((result: ArticleListResponse)=> setArticleList(result.data.articleList));
    }, []);
    console.log(articleList);

    return (
        <div>
            {articleList.map(article => 
            <li key={article.id}>
            <Link href={"/article/"+article.id}> {article.title}</Link>
            <Link href={"/article/"+article.id}> {article.content}</Link>
            </li>)}
        </div>
    )
}


