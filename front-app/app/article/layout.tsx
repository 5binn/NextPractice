import Link from "next/link";

export default function ArticleLayout({
    children,
}: Readonly<{
    children: React.ReactNode;
}>) {
    return (
        <div>
            ARTICLE
            <Link href="/article/post"> / POST</Link>
            {children}
        </div>
    );
}
